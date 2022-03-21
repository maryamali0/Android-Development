/*
 Maryam Ali
 IT-372
 PROJECT 4
 Due: May 28
*/

package it372.alim.project4_alimaryam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class DetailsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //retrieve values and set up types
        TextView txtAddress = findViewById(R.id.txt_address);
        TextView txtCity = findViewById(R.id.txt_city);
        TextView txtBedroom = findViewById(R.id.txt_bedroom);
        TextView txtBathroom = findViewById(R.id.txt_bathroom);
        TextView txtPrice = findViewById(R.id.txt_price);


        //return the intent that started this activity
        Intent intent = getIntent( );
        int touchId = intent.getIntExtra("id", 0);

        //extract and divide information
        InputStream is = getResources( ).openRawResource(R.raw.houses);
        Scanner s = new Scanner(is);
        s.nextLine( );
        while(s.hasNextLine( )) {
            String line = s.nextLine( );
            String[] fields = line.split(",");
            int id = Integer.parseInt(fields[0]);
            if (touchId == id) {
                String address = "Address: " + fields[3];
                String city = "City: " + fields[4];
                String bedroom = "Bedrooms: " + fields[5];
                String bathroom = "Bathrooms: " + fields[6];
                String price = "Price: $" + fields[7];

                //set values in widgets
                txtAddress.setText(address);
                txtCity.setText(city);
                txtBedroom.setText(bedroom);
                txtBathroom.setText(bathroom);
                txtPrice.setText(price);
                break;
            }
        }
        //close scanner
        s.close( );
    }
}

