package yyy.myappcompany.exampleapp49videopart1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView btn00,btn01,btn02,
            btn10,btn11,btn12,
            btn20,btn21,btn22;
    Button playAgain;
    int [][]field = {{0,0,0},{0,0,0},{0,0,0}} ;
    boolean isTurnRed = true;
    String winner;
    public void putStone(ImageView btn)
    {
        TextView textView = findViewById(R.id.textView);
        String tag=btn.getTag().toString();
        int y=Character.getNumericValue(tag.charAt(0));
        int x=Character.getNumericValue(tag.charAt(1));
        if(field[y][x] == 0) {
            if (isTurnRed) {
                float yCoor= btn.getY();
                btn.setBackgroundResource(R.drawable.red);
                btn.setY(-1000);
                btn.animate().translationYBy(yCoor+1000).setDuration(200);
                textView.setText("Turn Yellow");
                isTurnRed = false;
                field[y][x] = 1;
            } else {
                float yCoor= btn.getY();
                btn.setBackgroundResource(R.drawable.yellow);
                btn.setY(-1000);
                btn.animate().translationYBy(yCoor+1000).setDuration(200);
                textView.setText("Turn Red");
                isTurnRed = true;
                field[y][x] = 2;
            }
        }
        else Toast.makeText(this,"That area already filled",Toast.LENGTH_SHORT).show();

        Button btnPlay = findViewById(R.id.button);


        if(checkIsWon())
        {
            btnPlay.setVisibility(View.VISIBLE);
            if(isTurnRed) winner="Yellow";
            else winner="Red";
            textView.setText(winner+" won.");
            setButtonEnabled(false);
        }
        else if(checkIsFinished())
        {
            btnPlay.setVisibility(View.VISIBLE);
            textView.setText("Nobody won.");
            setButtonEnabled(false);
        }
    }

    public boolean checkIsWon()
    {

        for(int i=1;i<3;i++)
        {
            if(field[0][0] == i && field[0][1] == i && field[0][2] == i) return true;
            if(field[1][0] == i && field[1][1] == i && field[1][2] == i) return true;
            if(field[2][0] == i && field[2][1] == i && field[2][2] == i) return true;

            if(field[0][0] == i && field[1][0] == i && field[2][0] == i) return true;
            if(field[0][1] == i && field[1][1] == i && field[2][1] == i) return true;
            if(field[0][2] == i && field[1][2] == i && field[2][2] == i) return true;

            if(field[0][0] == i && field[1][1] == i && field[2][2] == i) return true;
            if(field[0][2] == i && field[1][1] == i && field[2][0] == i) return true;
        }

        return false;
    }
    public boolean checkIsFinished()
    {
        for (int i=0;i<=2;i++)
        {
            for (int j=0;j<=2;j++)
            {
                if(field[i][j]==0) return false;
            }
        }
        return true;
    }

    public void setButtonEnabled(boolean enable)
    {
        btn00 = findViewById(R.id.btn00);
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn20 = findViewById(R.id.btn20);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);

        btn00.setEnabled(enable);
        btn01.setEnabled(enable);
        btn02.setEnabled(enable);
        btn10.setEnabled(enable);
        btn11.setEnabled(enable);
        btn12.setEnabled(enable);
        btn20.setEnabled(enable);
        btn21.setEnabled(enable);
        btn22.setEnabled(enable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn00 = findViewById(R.id.btn00);
         btn01 = findViewById(R.id.btn01);
         btn02 = findViewById(R.id.btn02);
         btn10 = findViewById(R.id.btn10);
         btn11 = findViewById(R.id.btn11);
         btn12 = findViewById(R.id.btn12);
         btn20 = findViewById(R.id.btn20);
         btn21 = findViewById(R.id.btn21);
         btn22 = findViewById(R.id.btn22);
         playAgain = findViewById(R.id.button);
         TextView textView = findViewById(R.id.textView);
         textView.setText("Turn Red");

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn00);
            }
        });
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn01);
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn02);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn10);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn11);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn12);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn20);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn21);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStone(btn22);
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<=2;i++)
                {
                    for (int j=0;j<=2;j++)
                    {
                        field[i][j]=0;
                    }
                }
                btn00.setBackgroundResource(0);
                btn01.setBackgroundResource(0);
                btn02.setBackgroundResource(0);
                btn10.setBackgroundResource(0);
                btn11.setBackgroundResource(0);
                btn12.setBackgroundResource(0);
                btn20.setBackgroundResource(0);
                btn21.setBackgroundResource(0);
                btn22.setBackgroundResource(0);

                isTurnRed=true;

                playAgain.setVisibility(View.INVISIBLE);
                TextView textView = findViewById(R.id.textView);
                textView.setText("");
                setButtonEnabled(true);
                textView.setText("Turn Red");

            }
        });


    }
}