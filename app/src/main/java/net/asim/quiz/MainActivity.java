package net.asim.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    int calculateScore() {
        int score = 0;

        //check Question1:
        radioGroup = (RadioGroup) findViewById(R.id.question_1_radio_group);
        // get selected radio button from radioGroup
        int A1 = radioGroup.getCheckedRadioButtonId();
        if (A1 == R.id.Q1A2) {
            score++;
        }

        //check Question2:
        radioGroup = (RadioGroup) findViewById(R.id.question_2_radio_group);
        int A2 = radioGroup.getCheckedRadioButtonId();
        if (A2 == R.id.Q2A3) {
            score++;
        }

        //check Question3:
        EditText Q3 = (EditText) findViewById(R.id.Q3A1);
        String A3 = Q3.getText().toString();
        if (A3.contains("7.0")) {
            score++;
        }

        //check Question4:
        CheckBox Q4A1 = (CheckBox) findViewById(R.id.Q4A1);
        CheckBox Q4A2 = (CheckBox) findViewById(R.id.Q4A2);
        CheckBox Q4A3 = (CheckBox) findViewById(R.id.Q4A3);

        // correct answer: 1&3:
        if (Q4A1.isChecked() && Q4A3.isChecked() && !Q4A2.isChecked()) {
            score++;
        }
        return score;
    }

    public void submitQuiz(View view) {
        int score = this.calculateScore();

        String startStatment = getResources().getString(R.string.scoreStarting);
        String EndingStatment = getResources().getString(R.string.scoreEnding);

        Toast.makeText(MainActivity.this, (startStatment + " " + score + " " + EndingStatment), Toast.LENGTH_SHORT).show();
    }
}
