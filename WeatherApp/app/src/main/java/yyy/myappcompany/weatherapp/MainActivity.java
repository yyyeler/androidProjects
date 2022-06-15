package yyy.myappcompany.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText weatherInput;
    TextView resultText;
    String result;

    public void getWeather(View view)
    {
        weatherInput = findViewById(R.id.weatherInput);
        resultText = findViewById(R.id.ResultText);

        if(weatherInput.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill the input",Toast.LENGTH_SHORT).show();
            resultText.setText("");
        }
        else
        {
            DownloadData datas = new DownloadData();
            String encodedCityName= "";

            try {
                encodedCityName = URLEncoder.encode(weatherInput.getText().toString(),"UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q="+encodedCityName+"&appid=be7cc4d203b4853a2e4a86237fbafa3d";

            try {
                result=datas.execute(apiUrl).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            weatherInput.setText("");
        }

        InputMethodManager mng = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mng.hideSoftInputFromWindow(weatherInput.getWindowToken(),0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class DownloadData extends AsyncTask <String,Void,String>
    {

        @Override
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection connection = null;
            String result="";

            try {
                url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1)
                {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "false";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String main="";
            String message="";
            String description = "";
            String temperature = "";
            resultText = findViewById(R.id.ResultText);

            if(!s.equals("false"))
            {
                try
                {

                    JSONObject jsonObject = new JSONObject(s);

                    String temp = jsonObject.getString("weather");
                    JSONArray jsonArray = new JSONArray(temp);

                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonPart = jsonArray.getJSONObject(i);
                        main = jsonPart.getString("main");
                        description = jsonPart.getString("description");

                        if(!main.equals("") && !description.equals("")) message = main+" : "+description+"\r\n";
                    }

                    String temp2= jsonObject.getString("main");
                    JSONObject jsonObjectPart = new JSONObject(temp2);
                    temperature = jsonObjectPart.getString("temp");
                    if(!temperature.equals(""))
                    {
                        float temperature2 = Float.parseFloat(temperature);
                        temperature2 = temperature2- 273.15f;
                        message += "Temperature : "+String.valueOf(Math.round(temperature2))+" Celsius";

                    }
                    resultText.setText(message);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                resultText.setText("");
                Toast.makeText(getApplicationContext(),"There is no city like this",Toast.LENGTH_SHORT).show();
            }

        }

    }
}