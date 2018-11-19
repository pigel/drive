package lifesider.blogspot.com.driverhelper;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

import static lifesider.blogspot.com.driverhelper.MainActivity.inprobdaycity;
import static lifesider.blogspot.com.driverhelper.MainActivity.inprobdaytrassa;
import static lifesider.blogspot.com.driverhelper.MainActivity.inprobout;
import static lifesider.blogspot.com.driverhelper.MainActivity.sumcity;
import static lifesider.blogspot.com.driverhelper.MainActivity.sumtrassa;
import static lifesider.blogspot.com.driverhelper.MainActivity.wincity;
import static lifesider.blogspot.com.driverhelper.MainActivity.wintrassa;
import static lifesider.blogspot.com.driverhelper.inputfuel.FILE_NAME2;
import static lifesider.blogspot.com.driverhelper.inputfuel.infuelazs;
import static lifesider.blogspot.com.driverhelper.inputfuel.infuelout;

/**
 * Created by shai on 19.02.2018.
 */

public class result extends AppCompatActivity {

    public static double probinres;
    double fuelavecityres;
    double avetrassares;
    double avecommonres;
    public static double intankres;

    public final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_result);
    }

    //button winter intent
    public void OnClickWinter(View view) {
        TextView probin = findViewById(R.id.textView);
        TextView fuelavecity = findViewById(R.id.textView2);
        TextView fuelavetrassa = findViewById(R.id.textView3);
        TextView fuelavecommon = findViewById(R.id.textView4);
        TextView intank = findViewById(R.id.textView5);
        probinres = inprobout + inprobdaycity + inprobdaytrassa;
        fuelavecityres = inprobdaycity * wincity;
        avetrassares = inprobdaytrassa * wintrassa;
        avecommonres = fuelavecityres + avetrassares;
        intankres = (infuelout + infuelazs) - avecommonres;
        probin.setText("" + probinres);
        fuelavecityres = Math.round(fuelavecityres * 10) / 10.0d;
        fuelavecity.setText("" + fuelavecityres );
        avetrassares = Math.round(avetrassares * 10) / 10.0d;
        fuelavetrassa.setText("" + avetrassares);
        avecommonres = Math.round(avecommonres * 10) / 10.0d;
        fuelavecommon.setText("" + avecommonres);
        intankres = Math.round(intankres * 10) / 10.0d;
        intank.setText("" + intankres);
        onSave();
        onSavef();
    }
    //button summer
    public void onClickSummer(View view) {
        TextView probin = findViewById(R.id.textView);
        TextView fuelavecity = findViewById(R.id.textView2);
        TextView fuelavetrassa = findViewById(R.id.textView3);
        TextView fuelavecommon = findViewById(R.id.textView4);
        TextView intank = findViewById(R.id.textView5);
        probinres = inprobout + inprobdaycity + inprobdaytrassa;
        fuelavecityres = inprobdaycity * sumcity;
        avetrassares = inprobdaytrassa * sumtrassa;
        avecommonres = fuelavecityres + avetrassares;
        intankres = (infuelout + infuelazs) - avecommonres;
        probin.setText(""+probinres);
        fuelavecityres = Math.round(fuelavecityres * 10) / 10.0d;
        fuelavecity.setText("" + fuelavecityres);
        avetrassares = Math.round(avetrassares * 10) / 10.0d;
        fuelavetrassa.setText("" + avetrassares);
        avecommonres = Math.round(avecommonres * 10) / 10.0d;
        fuelavecommon.setText("" + avecommonres);
        intankres = Math.round(intankres * 10) / 10.0d;
        intank.setText("" + intankres);
        onSave();
        onSavef();
    }
    //savind file FILE_NAME
    public void onSave() {

        FileOutputStream fos = null;
        String text = String.valueOf(probinres);
        try {

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);//opened stream
            fos.write(text.getBytes());//written text here
            Toast.makeText(this, "file saved", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fos != null)
                    fos.close();//output stream is closed
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    //saving file FILE_NAME2
    public void onSavef() {

        FileOutputStream foss = null;
        String textt = String.valueOf(intankres);
        try {

            foss = openFileOutput(FILE_NAME2, MODE_PRIVATE);//opened stream
            foss.write(textt.getBytes());//written text here
            Toast.makeText(this, "file saved", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (foss != null)
                    foss.close();//output stream is closed
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }
    //menu initial

}
