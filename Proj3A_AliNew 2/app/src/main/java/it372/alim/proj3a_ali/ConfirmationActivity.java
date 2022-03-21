/*
Maryam Ali
Project 3B
May 14
*/

package it372.alim.proj3a_ali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {
    //declare private variable for text display
    private TextView txtName;
    private TextView txtEmail;
    private TextView txtBreed;
    private TextView txtDogName;
    private TextView txtExperience;
    private TextView txtResidence;
    private TextView txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        //Intent received on other end
        Intent intent = getIntent( );
        //Create fields for info separation
        String info = intent.getStringExtra("info");
        String[ ] fields = info.split(";");
        String name = fields[0];
        String email = fields[1];
        String breed = fields[2];
        String dog_name = fields[3];
        String experience = fields[4];
        String residence = fields[5];
        String age = fields[6];
        //Find object
        txtName = findViewById(R.id.txt_name);
        txtEmail = findViewById(R.id.txt_email);
        txtBreed = findViewById(R.id.txt_breed);
        txtDogName = findViewById(R.id.txt_dogName);
        txtExperience = findViewById(R.id.txt_experience);
        txtResidence = findViewById(R.id.txt_residence);
        txtAge = findViewById(R.id.txt_age);
        //Modify text display
        txtName.setText("Name: " + name);
        txtEmail.setText("Email: " + email);
        txtBreed.setText("Breed: " + breed);
        txtDogName.setText("Dog Name: " + dog_name);
        txtExperience.setText("Experienced?: " + experience);
        txtResidence.setText("Residence: " + residence);
        txtAge.setText("At least 21?: " + age);

    }
}
