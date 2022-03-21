/*
Maryam Ali
Proj 1B
April 17, 2020
*/

package it372.alim.proj1b_ali;

import java.util.ArrayList;
import java.util.Random;

public class Fact {
    //store facts in the AL
    private ArrayList<String> fc;
    //use the random object r to generate random numers
    private Random r;

    // Constructor to instantiate arraylist and random number generator object.
    public Fact() {
        fc = new ArrayList<String>();
        r = new Random();
    }

    //add fact to the Fact object fc.
    public void addFact(String new_fact) {
        fc.add(new_fact);
    }

    //Get a random fact for the AL
    public String getFact() {
        int randomNumber = r.nextInt(fc.size());
        return fc.get(randomNumber);
    }
}
