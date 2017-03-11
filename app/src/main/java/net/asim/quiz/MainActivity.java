package net.asim.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }
    //Question1:
    @BindView(R.id.question_1_radio_group) RadioGroup radioGroup;

    //Question2:
    @BindView(R.id.question_2_radio_group) RadioGroup radioGroup2;
    @BindView(R.id.Q2A3) RadioButton radioButton;

    //Question3:
    @BindView(R.id.Q3A1) EditText Q3;

    //Question4
    @BindView(R.id.Q4A1) CheckBox Q4A1;
    @BindView(R.id.Q4A2) CheckBox Q4A2;
    @BindView(R.id.Q4A3) CheckBox Q4A3;

    int calculateScore() {
        int score = 0;

        //check Question1:
        // get selected radio button from radioGroup
        int A1 = radioGroup.getCheckedRadioButtonId();
        if (A1 == R.id.Q1A2) {
            score++;
        }

        //check Question2:
        int A2 = radioGroup2.getCheckedRadioButtonId();
        if (A2 == radioButton.getId()) {
            score++;
        }

        //check Question3:
        String A3 = Q3.getText().toString();
        if (A3.contains("7.0")) {
            score++;
        }

        //check Question4:

        // correct answer: 1&3:
        if (Q4A1.isChecked() && Q4A3.isChecked() && !Q4A2.isChecked()) {
            score++;
        }
        return score;
    }

    public void submitQuiz(View view) {
        int score = this.calculateScore();

        if (score == 4) {
            Toast.makeText(MainActivity.this, (getResources().getString(R.string.awesome)), Toast.LENGTH_SHORT).show();
        } else {
            String startStatment = getResources().getString(R.string.scoreStarting);
            String EndingStatment = getResources().getString(R.string.scoreEnding);

            Toast.makeText(MainActivity.this, (startStatment + " " + score + " " + EndingStatment), Toast.LENGTH_SHORT).show();
        }
    }
}
