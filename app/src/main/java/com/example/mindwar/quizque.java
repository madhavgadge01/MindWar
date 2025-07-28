package com.example.mindwar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mindwar.config.constnts;

import java.util.List;
import helper.quetion;
import helper.questionGenretar;

public class quizque extends AppCompatActivity {

    LinearLayout ButtonA, ButtonB, ButtonC, ButtonD, next, previous;
    TextView questionText, questionNumber, optionTextA, optionTextB, optionTextC, optionTextD,timerText;

    int currentIndex = 0;
    int score = 0;
    boolean answered = false;

    List<quetion> questions;
    private CountDownTimer timer;
    private int totalTime=1*60;
    private int TimeLeft=totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizque);

        questions = questionGenretar.getQuetions();
        initializeViews();
        startTime();

        setQuestionsToView(questions.get(currentIndex));

        View.OnClickListener optionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered) return;

                answered = true;
                clearSelection();

                v.setBackgroundResource(R.drawable.bg_with_border); // Mark selected option

                String selectedAnswer = "";
                if (v == ButtonA) selectedAnswer = optionTextA.getText().toString();
                else if (v == ButtonB) selectedAnswer = optionTextB.getText().toString();
                else if (v == ButtonC) selectedAnswer = optionTextC.getText().toString();
                else if (v == ButtonD) selectedAnswer = optionTextD.getText().toString();

                String correctAnswer = questions.get(currentIndex).getAnswer();

                if (selectedAnswer.equals(correctAnswer)) {
                    score++;
                }
            }
        };

        ButtonA.setOnClickListener(optionClickListener);
        ButtonB.setOnClickListener(optionClickListener);
        ButtonC.setOnClickListener(optionClickListener);
        ButtonD.setOnClickListener(optionClickListener);

        previous.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                clearSelection();
                answered = false;
                setQuestionsToView(questions.get(currentIndex));
            } else {
                finish();
            }
        });

        next.setOnClickListener(v -> {
            if (currentIndex < questions.size() - 1) {
                currentIndex++;
                clearSelection();
                answered = false;
                setQuestionsToView(questions.get(currentIndex));
            } else if (score >= 6){
                Intent intent = new Intent(quizque.this, resultquiz.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.size());
                startActivity(intent);
                finish();
            }
            else {
                Intent intent = new Intent(quizque.this, LostActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.size());
                startActivity(intent);
                finish();
            }
        });
    }

    private void startTime() {
        timer=new CountDownTimer(constnts.total_exam_time*1000,1000) {
            @Override
            public void onFinish() {
                Intent intent = new Intent(quizque.this, LostActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.size());
                startActivity(intent);
                finish();
            }

            @Override
            public void onTick(long l) {

                int min = TimeLeft / 60;
                int sec = TimeLeft % 60;
                timerText.setText("TIME LEFT = MIN :" +min  +" SEC :"+ sec);

                TimeLeft--;

            }
        };
        timer.start();

    }

    private void initializeViews() {
        Toast.makeText(this, "Created by Madhav", Toast.LENGTH_SHORT).show();
        ButtonA = findViewById(R.id.ButtonA);
        ButtonB = findViewById(R.id.ButtonB);
        ButtonC = findViewById(R.id.ButtonC);
        ButtonD = findViewById(R.id.ButtonD);
        previous = findViewById(R.id.previous);
        timerText=findViewById(R.id.timerText);
        next = findViewById(R.id.next);
        questionText = findViewById(R.id.questionText);
        questionNumber = findViewById(R.id.questionNumber);
        optionTextA = findViewById(R.id.optionTextA);
        optionTextB = findViewById(R.id.optionTextB);
        optionTextC = findViewById(R.id.optionTextC);
        optionTextD = findViewById(R.id.optionTextD);
    }

    private void clearSelection() {
        ButtonA.setBackgroundResource(R.drawable.bg_without_border);
        ButtonB.setBackgroundResource(R.drawable.bg_without_border);
        ButtonC.setBackgroundResource(R.drawable.bg_without_border);
        ButtonD.setBackgroundResource(R.drawable.bg_without_border);
    }

    private void setQuestionsToView(quetion q) {
        questionNumber.setText(String.format("%02d", q.getId()));
        questionText.setText(q.getQuestions());
        optionTextA.setText(q.getOption1());
        optionTextB.setText(q.getOption2());
        optionTextC.setText(q.getOption3());
        optionTextD.setText(q.getOption4());
    }
}