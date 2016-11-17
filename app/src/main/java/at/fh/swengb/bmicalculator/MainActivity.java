package at.fh.swengb.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView resultView;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editTextWeight);
        editText2 = (EditText)findViewById(R.id.editTextHeight);
        resultView = (TextView) findViewById(R.id.textViewResult);
        resultText = (TextView) findViewById(R.id.textViewResultText);
    }


    public void calcBMI(View view) {

        String num1String = editText1.getText().toString();
        String num2String = editText2.getText().toString();

        double num1=0;
        double num2=0;

        double result = 0;
        try {
            num1=Double.parseDouble(num1String);
            num2=Double.parseDouble(num2String);
            if (num2 == 0) {
                resultView.setText("Your height can't be 0!");
            }
            else {
                result = num1 / (num2 * num2);
                result = Math.round(100.0 * result) / 100.0;
                if (result < 19) {
                    resultView.setText(result + "");
                    resultText.setText("You are underweight!");
                } else if (result >= 19 && result <= 24) {
                    resultView.setText(result + "");
                    resultText.setText("Yeah! You have an ideal weight!");
                } else if (result >= 25 && result <= 30) {
                    resultView.setText(result + "");
                    resultText.setText("You are overweight!");
                } else if (result >= 31) {
                    resultView.setText(result + "");
                    resultText.setText("You are really overweight, you should see a doctor!");
                }
            }
        } catch (NumberFormatException e) {
            resultView.setText("WRONG INPUT!!!!!");
            resultText.setText("Please only write numbers!");
            e.printStackTrace();
        }

    }

    public void showAbout(View view){
        Intent intent = new Intent(this, DisplayAboutActivity.class);
        String message = resultView.getText().toString();
        intent.putExtra("resultOfCalc",message);
        startActivity(intent);
    }
}
