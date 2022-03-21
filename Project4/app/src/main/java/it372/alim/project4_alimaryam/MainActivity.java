/*
 Maryam Ali
 IT-372
 PROJECT 4
 Due: May 28
*/

package it372.alim.project4_alimaryam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    //indicates fault tolerance before reporting as a failed test
    final float TOLERANCE = 10.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare MyView object as final (constant) if it is
        // used in the inner class.
        final MyView mv = new MyView(this);

        //find ll, modify background color and add view class
        LinearLayout layout = findViewById(R.id.linear_layout);
        mv.setBackgroundColor(Color.parseColor("#fbfe84"));
        layout.addView(mv);
        //set up event handler
        mv.setOnTouchListener(new View.OnTouchListener( ) {
            @Override
            public boolean onTouch(View view, MotionEvent e) {
                mv.performClick( );
                if(e.getAction( ) == MotionEvent.ACTION_DOWN) {
                    float xTouch = e.getX();
                    float yTouch = e.getY();
                    ArrayList<Point> points = mv.getArrayList();
                    for (Point p : points) {
                        int id = p.getId();
                        Float x = p.getX();
                        Float y = p.getY();
                        double distance = Math.sqrt(
                                Math.pow(xTouch - x, 2.0) +
                                        Math.pow(yTouch - y, 2.0));
                        if (distance < TOLERANCE) {
                            Intent intent = new Intent(
                                    MainActivity.this,
                                    DetailsActivity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);

                        }
                    }
                }

                // Return true so that the Touch event is consumed
                // and not available so other events like Click
                return true;
            }
        });
    }
}
