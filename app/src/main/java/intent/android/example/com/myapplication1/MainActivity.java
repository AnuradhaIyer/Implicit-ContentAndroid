package intent.android.example.com.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText6, editText8;
    Button ring, launch, close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText8 = (EditText) findViewById(R.id.editText8);
        ring = (Button) findViewById(R.id.button8);
        launch = (Button) findViewById(R.id.button7);
        close = (Button)findViewById(R.id.button9);


        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editText6.getText().toString();
                Intent urlIntent = new Intent(Intent.ACTION_VIEW);
                urlIntent.setData(Uri.parse("http://" + url));
                startActivity(urlIntent);
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editText8.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:+number"));
                startActivity(callIntent);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to stop android application
                moveTaskToBack(true);
                finish();
            }
        });
    }


    public void finishActivity() {
        MainActivity.this.finish();
    }
}
