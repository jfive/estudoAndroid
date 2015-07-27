package dominando.android.ex01_hello;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import dominando.android.ex01_hello.parcelable.Cliente;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    EditText edtTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        displayMetrics();

        return true;
    }

    private void displayMetrics() {
        Configuration configuration = getResources().getConfiguration();
        DisplayMetrics metrics = getResources().getDisplayMetrics();

        int orientation = configuration.orientation;
        float density = metrics.density;
        float height = metrics.heightPixels / metrics.density;
        float width = metrics.widthPixels / metrics.density;
        int mcc = configuration.mcc;
        int mnc = configuration.mnc;

        Locale locale = configuration.locale;
        Log.d("NGVL", "density:" + density);
        Log.d("NGVL", "orientation: " + orientation);
        Log.d("NGVL", "height: " + height);
        Log.d("NGVL", "width: " + width);
        Log.d("NGVL", "language: " + locale.getLanguage() + "-" + locale.getCountry());
        Log.d("NGVL", "mcc: " + mcc);
        Log.d("NGVL", "mnc: " + mnc);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                String texto = edtTexto.getText().toString();
                Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Intent it = new Intent(this, Tela2Activity.class);
                it.putExtra("nome", "Rodrigo");
                it.putExtra("idade", 32);
                startActivity(it);
                break;
            case R.id.button3:
                Cliente cliente = new Cliente(1,"Rodrigo Almeida");
                Intent intent = new Intent(this, Tela2Activity.class);
                intent.putExtra("cliente", cliente);
                startActivity(intent);
                break;
        }
    }
}