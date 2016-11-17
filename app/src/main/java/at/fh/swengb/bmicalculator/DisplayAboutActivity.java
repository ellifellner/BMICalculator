package at.fh.swengb.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about);

        Intent intent = getIntent();

        String message = intent.getStringExtra("resultOfCalc");
        TextView textView = (TextView) findViewById(R.id.textViewMessage);

        textView.setText("Your BMI is "+message);

    }

}
