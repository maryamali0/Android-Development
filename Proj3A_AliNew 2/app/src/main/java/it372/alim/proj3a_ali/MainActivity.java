/*
Maryam Ali
Project 3B
May 14
*/

package it372.alim.proj3a_ali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declare private variables
    private EditText edtName;
    private EditText edtEmail;
    private Spinner spnBreed;
    private EditText edtDogName;
    private CheckBox chkExperience;
    private RadioButton radOwn;
    private RadioButton radRent;
    private CheckBox chkAge;
    private TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find object
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        spnBreed = findViewById(R.id.spn_breed);
        edtDogName = findViewById(R.id.edt_dogName);
        chkExperience = findViewById(R.id.chk_experience);
        radOwn = findViewById(R.id.rad_own);
        radRent = findViewById(R.id.rad_rent);
        chkAge = findViewById(R.id.chk_age);
        txtView = findViewById(R.id.txt_display);
        //Conditional for bundle, will save input in widgets if they exist
        if (savedInstanceState != null) {
            txtView.setText(savedInstanceState.getString("eventLog"));
        }


    }


    public void submitInfo(View view) {
        //Convert values to strings
        String name =  edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String breed =  spnBreed.getSelectedItem( ).toString( );
        String dog_name = edtDogName.getText().toString();
        boolean experience = chkExperience.isChecked( );
        String residence = radOwn.isChecked() ? "Own" : "Rent";
        boolean age = chkAge.isChecked();
        //Format the string
        String info = String.format("%s;%s;%s;%s;%s;%s;%s",
                name, email, breed, dog_name, experience, residence, age);
        //Create an intent for the purpose of a new activity
        Intent intent = new Intent(this,
                ConfirmationActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);
    }

    //Create event handler
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("eventLog", txtView.getText().toString());
    }
}
