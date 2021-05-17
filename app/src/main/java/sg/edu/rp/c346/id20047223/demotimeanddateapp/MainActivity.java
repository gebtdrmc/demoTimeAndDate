package sg.edu.rp.c346.id20047223.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btndisplaydate;
    Button btndisplaytime;
    Button resetbtn;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datepick);
        tp = findViewById(R.id.timepick);
        btndisplaydate = findViewById(R.id.buttonDisplayDate);
        btndisplaytime = findViewById(R.id.buttonDisplayTime);
        resetbtn = findViewById(R.id.resetbtn);
        tvDisplay = findViewById(R.id.textviewans);

        btndisplaytime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setIs24HourView(true);
                if(tp.getCurrentMinute() >= 10) {
                    tvDisplay.setText("Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute());
                } else {
                    tvDisplay.setText("Time is " + tp.getCurrentHour() + ":0" + tp.getCurrentMinute());
                }
            }
        });

        btndisplaydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText(dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear());
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(00);

                dp.updateDate(2020,0, 1);
            }
        });

    }
}