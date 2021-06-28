package com.roshanaryal.calculatersimple;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mGetFirstNumber;
    EditText mGetSecondNummber;
    TextView mResultText;
    Spinner  mSpinner;
    Button mButton;
   String mString1;
    String mString2;
    String getText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGetFirstNumber=(EditText)findViewById(R.id.get_first);
        mGetSecondNummber=(EditText)findViewById(R.id.get_second_number);
        mResultText=(TextView)findViewById(R.id.result_text);
        mSpinner=(Spinner)findViewById(R.id.spinner);
        mButton=(Button)findViewById(R.id.button);



            //mString1=mGetFirstNumber.getText().toString();
       // mString2=mGetSecondNummber.getText().toString();


        //  mString1=Integer.parseInt(mGetFirstNumber.getText().toString());
      //  mString2=Integer.parseInt(mGetSecondNummber.getText().toString());

        ArrayAdapter <CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.spinner_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getText = mSpinner.getSelectedItem().toString();
                Log.d("Calculator","String="+getText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mString1=mGetFirstNumber.getText().toString();
                mString2=mGetSecondNummber.getText().toString();
                if (mString2.isEmpty()||mString1.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Number\nText field cannot be empty",Toast.LENGTH_SHORT).show();;
                }
                else {

                    final double firstno = Double.parseDouble(mString1);
                    final double secondno = Double.parseDouble(mString2);

                    if (getText.equals("Add")) {
                        Double result = firstno + secondno;
                        String resultString = String.format(" Sum = %.2f", result);
                        Toast.makeText(getApplicationContext(), "Sum=" + resultString, Toast.LENGTH_SHORT).show();
                        ;
                        mResultText.setText((resultString));

                        //mResultText.setText((num));
                    } else if (getText.equals("Subtract")) {
                        Double result = firstno - secondno;
                        String resultString = String.format("%.2f", result);
                        Toast.makeText(getApplicationContext(), "Sum=" + resultString, Toast.LENGTH_SHORT).show();
                        ;
                        mResultText.setText((resultString));
                    } else if (getText.equals("Multiply")) {
                        Double result = firstno * secondno;
                        String resultString = String.format("%.2f", result);
                        Toast.makeText(getApplicationContext(), "Sum=" + resultString, Toast.LENGTH_SHORT).show();
                        ;
                        mResultText.setText((resultString));
                    } else {
                        Double result = firstno / secondno;
                        String resultString = String.format("%.2f", result);
                        Toast.makeText(getApplicationContext(), "Sum=" + resultString, Toast.LENGTH_SHORT).show();
                        ;
                        mResultText.setText((resultString));
                    }
                }

                /*
                else {
                    Toast.makeText(getApplicationContext(),"Enter Number\nText field cannot be empty",Toast.LENGTH_SHORT).show();;
                }*/
            }
        });



    }
}
