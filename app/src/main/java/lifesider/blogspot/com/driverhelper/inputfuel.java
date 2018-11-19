package lifesider.blogspot.com.driverhelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by shai on 19.02.2018.
 */

public class inputfuel extends AppCompatActivity {

    EditText mfuelout;
    EditText mfuelazs;
    static float infuelout;
    static float infuelazs;
    public final static String FILE_NAME2 = "content2.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_inputfuel);
        mfuelout = findViewById(R.id.efuelout);
        mfuelazs = findViewById(R.id.efuelazs);
    }

    public void onClick(View view) {
        //если длина введенного текста равна нулю - возврат
        if (mfuelout.getText().length() == 0) return;
        else {
            infuelout = Float.parseFloat(mfuelout.getText().toString());
        }
        if (mfuelazs.getText().length() == 0) infuelazs = 0;
        else {
            infuelazs = Float.parseFloat(mfuelazs.getText().toString());
        }
        Intent intent = new Intent(inputfuel.this, result.class);
        startActivity(intent);
    }

    public void onClickPred(View view) {
        onOpenf();
    }
    private void onOpenf() {

        FileInputStream fin = null;

        try {
            fin = openFileInput(FILE_NAME2);//let's create stream
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            mfuelout.setText(text);
        } catch (IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {

            try {
                if (fin != null)
                    fin.close();///close stream
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }


}