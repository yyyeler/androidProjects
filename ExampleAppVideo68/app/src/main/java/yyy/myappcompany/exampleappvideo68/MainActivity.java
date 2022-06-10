package yyy.myappcompany.exampleappvideo68;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {
    CountDownTimer cmt;
    SeekBar seekBar;
    int count=30;
    boolean isStarted=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(30);
        seekBar.setMin(1);
        seekBar.setMax(600);

        textView.setText(setTimeText(seekBar.getProgress()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                count=progress;
                textView.setText(setTimeText(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStarted)
                {
                    cmt=new CountDownTimer(count*1000,1000)
                    {
                        public void onTick(long millisecondsUntilDone)
                        {
                            TextView textView = findViewById(R.id.textView);
                            textView.setText(setTimeText((int)(millisecondsUntilDone/1000)));

                        }
                        public void onFinish()
                        {
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.alarm);
                            mediaPlayer.start();
                            seekBar.setEnabled(true);
                            button.setText("GO!");
                            isStarted=false;
                        }
                    }.start();

                    button.setText("Pause!");
                    seekBar.setEnabled(false);
                    isStarted=true;
                }
                else
                {
                    String text = textView.getText().toString();
                    int time = (Integer.parseInt(text.substring(0,2))*60)+Integer.parseInt(text.substring(3,5));
                    seekBar.setProgress(time);
                    cmt.cancel();
                    button.setText("GO!");
                    isStarted=false;
                    seekBar.setEnabled(true);
                }
            }
        });
    }

    public String setTimeText(int time)
    {
        int temp1,temp2;
        temp1 = (int)Math.floor((int)(time)/60);
        String minute,seconds;
        if(temp1>=10) minute=String.valueOf(temp1);
        else minute="0"+temp1;

        temp2=time%60;
        if(temp2>=10) seconds=String.valueOf(temp2);
        else seconds="0"+temp2;
        return minute+":"+seconds;
    }
}