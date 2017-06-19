package jp.techacademy.kotoyu.sasayama.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    int mHour;      //　時間
    int mMinuts;    //  分

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button1) {
            CreateTimePickerDialog(v.getId());
            SayGeeting();
        } else if (v.getId() == R.id.button2) {
            CreateTimePickerDialog(v.getId());
        }
    }

    private void CreateTimePickerDialog(int id){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                mHour = i;
                mMinuts = i1;
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                timeSetListener,
                13,     // 初期値
                0,      // 初期値
                true);

        if(id == R.id.button2) {
            timePickerDialog.show();
        }
    }

    private void SayGeeting(){
        if(2 <= mHour  && mHour < 10){
            mTextView.setText("おはよう");
        } else if(10 <= mHour && mHour < 18){
            mTextView.setText("こんにちは");
        } else{
            mTextView.setText("こんばんは");
        }

}


}
