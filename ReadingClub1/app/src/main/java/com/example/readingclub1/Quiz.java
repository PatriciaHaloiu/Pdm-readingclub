package com.example.readingclub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity {

    private TextView tvQuestion, tvQuestionNo, tvScore, tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3;
    private Button btnNext;


    int totalQ;
    int qCount=0;
    int score;


    private QuestionModel currentQ;

    ColorStateList dfRbColor;
    CountDownTimer countDownTimer;
    boolean answered;


    private List<QuestionModel> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionList = new ArrayList<>();
        tvQuestion=findViewById(R.id.intrebare);
        tvQuestionNo=findViewById(R.id.intrebari);
        tvScore=findViewById(R.id.score);
        tvTimer=findViewById(R.id.timer);

        radioGroup=findViewById(R.id.radioGroup);

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);

        btnNext=findViewById(R.id.btnNext);

        dfRbColor=rb1.getTextColors();

        addQuestions();
        totalQ=questionList.size();
        showNextQ();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == false){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                        countDownTimer.cancel();
                    }else{
                        Toast.makeText(Quiz.this, "Selecteaza un raspuns", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQ();
                }


            }

        });
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answereNo= radioGroup.indexOfChild(rbSelected) + 1;
        if(answereNo == currentQ.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score: "+score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch (currentQ.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }
        if(qCount<totalQ){
            btnNext.setText("Next");
        }else{
            btnNext.setText("Finish");
        }
    }

    private void showNextQ(){

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);


        if(qCount<totalQ){
            timer();
            currentQ=questionList.get(qCount);
            tvQuestion.setText(currentQ.getQuestion());
            rb1.setText(currentQ.getOption1());
            rb2.setText(currentQ.getOption2());
            rb3.setText(currentQ.getOption3());

            qCount++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Intrebarea: "+qCount+"/"+totalQ);
            answered = false;

        }else{
            finish();
        }
    }

    private void timer() {
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("00:" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                showNextQ();
            }
        }.start();
    }

    private void addQuestions(){
        questionList.add(new QuestionModel("Which author wrote the 1960 novel To Kill a Mockingbird?","Arthur Hailey","Allen Drury","Harper Lee",3));
        questionList.add(new QuestionModel("Which book won the 2020 Pulitzer Prize in the fiction category?","The Nickel Boys","The Overstory","The Goldfinch",1));
        questionList.add(new QuestionModel("Harry Potter and the Philosopher’s Stone, the first book in the Harry Potter series, goes by which name in the USA?","Harry Potter and the Emperor's Gem","Harry Potter and the Sorcerer's Stone.","Harry Potter and the Magical Feast",2));
        questionList.add(new QuestionModel("What is the name of the second volume in the series The Lord of the Rings?","The Treason of Isengard","The Ring Sets Out","The End of the Third Age.",1));
        questionList.add(new QuestionModel("What Stephen King book was published first?","Christine","Insonomia","Carrie",3));
        questionList.add(new QuestionModel(" What was the working title of Jane Austin’s Pride and Prejudice?","There's Always Tomorrow","Judgment and Clarity","First Impressions",3));
        questionList.add(new QuestionModel("Anthony Doerr’s novel All the Light We Cannot See is set in which war?","World War II","World War I","The Cold War",1));

    }
}