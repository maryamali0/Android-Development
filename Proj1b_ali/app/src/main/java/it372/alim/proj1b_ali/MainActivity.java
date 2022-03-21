/*
Maryam Ali
Proj 1B
April 17, 2020
*/

package it372.alim.proj1b_ali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Make the Fact class an instance var
    Fact f = new Fact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add 11 facts to the Fact class f
        f.addFact("There is a super massive black hole at the center of our Milky Way Galaxy, named Sagittarius A*");
        f.addFact("Neptune takes 165 years to complete one orbit around the sun, the longest orbit of our solar system.");
        f.addFact("Halley's comet will next be visible in the night sky in the year 2061.");
        f.addFact("Mercury is the smallest planet in the solar system, it used to be Pluto.");
        f.addFact("Venus is the hottest planet in the solar system, reaching temperatures of up to 800+ fahrenheit.");
        f.addFact("Unlike other planets, Uranus's tilt is so great that it spins on its side.");
        f.addFact("Mars gets its red color from the presence of copious amounts of iron oxide");
        f.addFact("Saturn has some of the fastest winds in the solar system, reaching speeds of up to 1118 mph.");
        f.addFact("Jupiter's great red spot is a giant storm that is twice the size of earth.");
        f.addFact("The sun makes up about 99.86% of the mass in the solar system.");
        f.addFact("The distance between the Earth and the Moon is 238,900 miles.");
    }

    //Event handler for the onClick event of the LL
    public void showFact(View view) {
        //create the TextView object tv from the textview in the layout
        TextView tv = findViewById(R.id.txt_fact);
        //get a fact from the Fact object f
        tv.setText(f.getFact());
    }
}
