package lifesider.blogspot.com.driverhelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

import static lifesider.blogspot.com.driverhelper.result.FILE_NAME;

public class MainActivity extends AppCompatActivity {
    EditText mprobout;
    EditText mprobdaycity;
    EditText mrobdaytrassa;
    public static double inprobout;
    public static double inprobdaycity;
    public static double inprobdaytrassa;

    public static double wintrassa;
    public static double wincity;
    public static double sumcity;
    public static double sumtrassa;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        mprobout=findViewById(R.id.eprobout);
        mprobdaycity=findViewById(R.id.ecity);
        mrobdaytrassa=findViewById(R.id.etrassa);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
    }
    @Override
    protected void onResume() {
        String wtr = sp.getString("edit_text_preference", "0");
        wintrassa= Double.parseDouble(wtr)/100;
        String wtc = sp.getString("edit_text_preference_1", "0");
        wincity= Double.parseDouble(wtc)/100;
        String sumc = sp.getString("edit_text_preference_2", "0");
        sumcity= Double.parseDouble(sumc)/100;
        String st = sp.getString("edit_text_preference_3", "0");
        sumtrassa= Double.parseDouble(st)/100;

        super.onResume();
    }
    public void onClick(View view) {

        //if lenght of data = 0 return

        if (mprobout.getText().length() == 0)return;
        else {
            inprobout = Float.parseFloat(mprobout.getText().toString());
        }

        if (mprobdaycity.getText().length() == 0)inprobdaycity=0;
        else {
            inprobdaycity = Float.parseFloat(mprobdaycity.getText().toString());
        }

        if (mrobdaytrassa.getText().length() == 0)inprobdaytrassa=0;
        else {
            inprobdaytrassa = Float.parseFloat(mrobdaytrassa.getText().toString());
        }
        //request result class
        Intent intent=new Intent(MainActivity.this,inputfuel.class);
        startActivity(intent);
    }
    //button request onOpen method
    public void onPredClick(View view) {
        onOpen();
    }

    private void onOpen(){

        FileInputStream fin = null;

        try {
            fin = openFileInput(FILE_NAME);//let's create stream
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            mprobout.setText(text);
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();//close stream
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //menu initial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void click(MenuItem item) {
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
    }

    public void clickAbout(MenuItem item) {
        Intent intent=new Intent(MainActivity.this,AboutActivity.class);
        startActivity(intent);
    }
}
