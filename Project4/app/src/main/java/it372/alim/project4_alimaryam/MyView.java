/*
 Maryam Ali
 IT-372
 PROJECT 4
 Due: May 28
*/

package it372.alim.project4_alimaryam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MyView extends View {
    private Paint paint = new Paint( );
    //create scanner for houses
    private InputStream is =
            getResources( ).openRawResource(R.raw.houses);
    private Scanner s = new Scanner(is);

    //set format
    private ArrayList<Point> points;
    float prevx = 0.0f;
    float prevy = 0.0f;

    //split fields for dimension values
    public MyView(Context c) {
        super(c);
        points = new ArrayList<>( );
        s.nextLine( );
        while(s.hasNextLine( )) {
            String line = s.nextLine();
            String[] fields = line.split(",");
            int id = Integer.parseInt(fields[0]);
            Float x = 30.0f * Float.parseFloat(fields[1]);
            Float y = 30.0f * Float.parseFloat(fields[2]);
            points.add(new Point(id, x, y));
        }
        s.close( );


    }

    public ArrayList<Point> getArrayList( ) {
        return points;
    }

    @Override
    public void onDraw(Canvas c) {
        //create scanner for river
        InputStream is1 =  getResources( ).openRawResource(R.raw.rivers);
        Scanner s2 = new Scanner(is1);

        //modify river appearance
        Paint paint = new Paint( );
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3.0f);
        s2.nextLine( );


        //modify river dimensions
        while(s2.hasNextLine( )) {
            String line = s2.nextLine( );
            String[ ] fields = line.split(",");
            float x = 30.0f * Float.parseFloat(fields[0]);
            float y = 30.0f * Float.parseFloat(fields[1]);
            int startPoint = Integer.parseInt(fields[2]);
            if (startPoint == 0) {
                //connect dots from previous x and y
                c.drawLine(prevx, prevy, x, y, paint);
            }
            //after you are done drawing, the current x becomes the previous x and current y
            //becomes the previous y
            prevx = x;
            prevy = y;
        }
        //draw points for the houses and modify attributes
        s2.close();
        paint.setColor(Color.RED);
        for(Point p : points) {
            c.drawCircle(p.getX( ), p.getY( ), 10, paint);
        }

    }

    //performs all normal actions associated with clicking
    public boolean performClick( ) {
        return true;
    }
}

