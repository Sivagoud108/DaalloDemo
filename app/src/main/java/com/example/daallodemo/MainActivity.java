  package com.example.daallodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.daallodemo.Activites.MtowActivity;
import com.example.daallodemo.Activites.OneWay;
import com.example.daallodemo.Activites.Round;

  public class MainActivity extends AppCompatActivity {

   private Button findflight;
   // LinearLayout layout;
   TextView calender;
// private Toolbar toolbar;
  private RadioButton oneway , roundTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     oneway = findViewById(R.id.oneway);
     roundTrip =findViewById(R.id.roundTrip);
//    toolbar = findViewById(R.id.toolbar);

        findflight = findViewById(R.id.findFlight);
        /*calender = findViewById(R.id.departureDate);*/

        replaceFragment(new OneWay());

       /* calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });*/

        findflight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MtowActivity.class);
                startActivity(i);
            }
        });

        oneway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new OneWay());
            }
        });
        roundTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Round());
            }
        });
        }

    private void openDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calender.setText(String.valueOf(year)+"."+String.valueOf(month+1)+"."+String.valueOf(day));

            }
        },2023, 0, 12);

        datePickerDialog.show();


        /*TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hours, int miniutes) {
                text.setText(String.valueOf(hours)+"."+String.valueOf(miniutes));

            }
        },15,00,true);
        dialog.show();*/
    }

    private void replaceFragment(OneWay oneWay) {

    }

      private void replaceFragment(Round round) {

      }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();


    }

}