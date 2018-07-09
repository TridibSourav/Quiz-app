package com.example.tspc.quizsimulator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView question, score;
    Button bTrue;
    Button bFlase;
    Button bnTrue;
    Button bnFlase;
    int questioncounter =0;
    int scorecounter=0;

    QuestionAnswer qa[]= new QuestionAnswer[]
            {
                    new QuestionAnswer(R.string.q1,true),
                    new QuestionAnswer(R.string.q2,false),
                    new QuestionAnswer(R.string.q3,true),
                    new QuestionAnswer(R.string.q4,false),
                    new QuestionAnswer(R.string.q5,true),

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question= findViewById(R.id.question);
        score=findViewById(R.id.score);
        bTrue=findViewById(R.id.truth);
        bFlase=findViewById(R.id.flase);

        question.setText(qa[questioncounter].getQuestionId());
        score.setText("0");
        bTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        bFlase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
    }
    private void checkAnswer(Boolean selection) {
        Boolean rightAnswer =(qa[questioncounter].getAnswer());
        if (selection == rightAnswer){
            scorecounter = scorecounter+1;
    }
    questioncounter = (questioncounter+1);
        if (questioncounter>=qa.length){
            //
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("your scrore"+scorecounter)
                    .setTitle("scoreboard");

            builder.setPositiveButton("close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // add finish
                    finish();
                }
            });

            builder.create().show();


        }
        else{
        question.setText(qa[questioncounter].getQuestionId());
        score.setText(scorecounter+"");
        }

    }

}
