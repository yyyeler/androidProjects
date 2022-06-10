package yyy.myappcompany.exampleappvideo70;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button showBtn;
    Button a,b,c,d;
    ImageButton soundBtn;
    TextView txt,timeText,questionText,ratioText,resultText;
    LinearLayout tab;
    GridLayout grid;
    Random random = new Random();
    int answer;
    MediaPlayer mediaPlayer;
    boolean isMute=false;
    boolean isPlay=true;
    CountDownTimer cmt;

    public void play(View view)
    {
        showBtn = findViewById(R.id.play);
        txt = findViewById(R.id.txt);
        tab = findViewById(R.id.tab);
        grid = findViewById(R.id.grid);
        resultText = findViewById(R.id.result);
        ratioText = findViewById(R.id.ratioText);
        soundBtn = findViewById(R.id.soundBtn);

        if(isPlay)
        {
            txt.setVisibility(View.INVISIBLE);
            grid.setVisibility(View.VISIBLE);
            tab.setVisibility(View.VISIBLE);
            resultText.setText("");
            showBtn.setText("QUIT!");

            runTheClock(30);
            answer = makeQuestion();
            makeTheChoices(answer);

            a.setEnabled(true);
            b.setEnabled(true);
            c.setEnabled(true);
            d.setEnabled(true);
            ratioText.setText("0/0");
            soundBtn.setVisibility(View.VISIBLE);
            isPlay=false;
        }
        else
        {

            showBtn.setText("PLAY!");
            txt.setVisibility(View.VISIBLE);
            grid.setVisibility(View.INVISIBLE);
            tab.setVisibility(View.INVISIBLE);
            resultText.setText("");
            soundBtn.setVisibility(View.INVISIBLE);
            isPlay=true;
            cmt.cancel();
        }

    }

    public void arrangeSound(View view)
    {
        if(isMute)
        {
            soundBtn = findViewById(R.id.soundBtn);
            soundBtn.setImageResource(R.drawable.speaker);
            isMute=false;
        }
        else
        {

            soundBtn = findViewById(R.id.soundBtn);
            soundBtn.setImageResource(R.drawable.mute);
            isMute=true;
        }
    }

    public void runTheClock(int seconds)
    {
        timeText = findViewById(R.id.timeText);
        resultText = findViewById(R.id.result);
        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        c = findViewById(R.id.C);
        d = findViewById(R.id.D);
        showBtn = findViewById(R.id.play);

        cmt=new CountDownTimer((seconds*1000)+100,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText(String.valueOf((int)(millisUntilFinished/1000))+"s");
            }

            @Override
            public void onFinish() {
                resultText.setTextColor(Color.RED);
                resultText.setText("Time is up!");
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                showBtn.setText("PLAY AGAIN!");
                showBtn.setVisibility(View.VISIBLE);
                isPlay=true;
                if(!isMute)
                {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.alarm);
                    mediaPlayer.start();
                }
            }
            }.start();
    }

    public void getChoice(View view)
    {
        Button btn = (Button)view;
        resultText = findViewById(R.id.result);
        ratioText = findViewById(R.id.ratioText);

        String ratio = ratioText.getText().toString();

        String [] ratioValues = ratio.split("/");
        int trueAns = Integer.parseInt(ratioValues[0]);
        int allAns =  Integer.parseInt(ratioValues[1])+1;

        int selected=Integer.parseInt(btn.getText().toString());

        if(answer == selected)
        {
            trueAns++;
            resultText.setTextColor(Color.GREEN);
            resultText.setText("Correct!");
            if(!isMute)
            {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.correct);
                mediaPlayer.start();
            }
        }
        else
        {
            resultText.setTextColor(Color.RED);
            resultText.setText("Wrong!");
            if(!isMute)
            {
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.wrong);
                mediaPlayer.start();
            }
        }

        ratioText.setText((trueAns+"/"+allAns));

        answer = makeQuestion();
        makeTheChoices(answer);
    }

    public int makeQuestion()
    {
        int operator=random.nextInt(4);
        int numb1 = random.nextInt(100)+1;
        int numb2;

        if(operator == 1)
        {
            numb2 = random.nextInt(numb1)+1;
        }
        else if (operator == 3)
        {
            numb2 = random.nextInt(numb1)+1;
            while (numb1%numb2!=0)
            {
                numb2 = random.nextInt(numb1)+1;
            }
        }
        else
            numb2 = random.nextInt(numb1)+1;

        questionText = findViewById(R.id.questionText);
        int answer = 0;
        switch (operator)
        {
            case 0:
                questionText.setText(numb1+"+"+numb2);
                answer=numb1+numb2;
                break;
            case 1:
                questionText.setText(numb1+"-"+numb2);
                answer=numb1-numb2;
                break;
            case 2:
                questionText.setText(numb1+"*"+numb2);
                answer=numb1*numb2;
                break;
            case 3:
                questionText.setText(numb1+"/"+numb2);
                answer=numb1/numb2;
                break;
            default :
                break;
        }
        return answer;
    }

    public void makeTheChoices(int answer)
    {
        ArrayList<Integer> arrayChoices = new ArrayList<Integer>();
        arrayChoices.add(answer);
        int temp = random.nextInt(200);

        for(int i=0;i<4;i++)
        {
            while(arrayChoices.contains(temp))
            {
                temp = random.nextInt(200);
            }
            arrayChoices.add(temp);
        }


        a.setText(arrayChoices.get(1).toString());
        b.setText(arrayChoices.get(2).toString());
        c.setText(arrayChoices.get(3).toString());
        d.setText(arrayChoices.get(4).toString());

        int choice = random.nextInt(4);

        switch (choice)
        {
            case 0:
                a.setText(String.valueOf(answer));
                break;
            case 1:
                b.setText(String.valueOf(answer));
                break;
            case 2:
                c.setText(String.valueOf(answer));
                break;
            case 3:
                d.setText(String.valueOf(answer));
                break;
            default :
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}