/*
Maryam Ali
Project 2
04/24/20
*/

package it372.alim.proj2_ali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    //Retrieve input from the P,R,N boxes
    public void calcPayment(View view) {
        EditText edtPrincipal = findViewById(R.id.edt_principal);
        EditText edtRate = findViewById(R.id.edt_rate);
        EditText edtYears = findViewById(R.id.edt_num_years);
        TextView txtPayment = findViewById(R.id.txt_payment);


        try {

            //Convert inputs to numbers and evaluate
            float p = Float.parseFloat(
                    edtPrincipal.getText().toString());
            float r = Float.parseFloat(
                    edtRate.getText().toString());
            int n = Integer.parseInt(
                    edtYears.getText().toString());

            double m = ((p * r) / 1200.0) / (1 - Math.pow(1.0 + r/1200.0,-12 * n));

            //Convert back to string
            String.valueOf(m);
            String mp = String.format("$%.2f", m);
            txtPayment.setText(String.valueOf(mp));

        //if input is not a number, display NaN
        } catch (NumberFormatException e) {
            txtPayment.setText("NaN");

        }
    }
}



