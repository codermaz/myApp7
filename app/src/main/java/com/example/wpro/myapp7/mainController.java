package com.example.wpro.myapp7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class mainController extends AppCompatActivity {

    EditText getDateText, getTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        // intialize EditText
        getDateText = (EditText) findViewById(R.id.getDateEditText);
        getTimeText = (EditText) findViewById(R.id.getTimeEditText);

        // listen EditText
        getDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get current date
                Calendar cDate = Calendar.getInstance();
                int cYear = cDate.get(Calendar.YEAR);
                int cMonth = cDate.get(Calendar.MONTH);
                int cDay = cDate.get(Calendar.DAY_OF_MONTH);

                // initialize and show DateDialog
                new DatePickerDialog(
                        mainController.this,
                        // listen DateDialog
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // show selected day in EditText
                                getDateText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, cYear, cMonth, cDay
                ).show();

            }
        });


        // listen EditText
        getTimeText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // get current time
               Calendar cTime = Calendar.getInstance();
               final int cHour = cTime.get(Calendar.HOUR_OF_DAY);
               final int cMinute = cTime.get(Calendar.MINUTE);
               // initialize and show TimeDialog
               new TimePickerDialog(
                       mainController.this,
                       new TimePickerDialog.OnTimeSetListener() {
                            // listen Time Dialog
                           @Override
                           public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // show selected time in the EditText
                               getTimeText.setText(cHour+":"+cMinute);
                           }
                       }, cHour, cMinute, true

               ).show();
           }
        }
        );
    }
}
