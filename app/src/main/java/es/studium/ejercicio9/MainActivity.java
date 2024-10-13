package es.studium.ejercicio9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnButton;
    EditText text;
    EditText error;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnButton = findViewById(R.id.button);
        btnButton.setOnClickListener(this);

        text = findViewById(R.id.fecha);
        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String fecha = text.getText().toString();

        if(fecha.isEmpty())
        {
            Toast.makeText(this, R.string.mensaje_error2, Toast.LENGTH_SHORT).show();
        }
        else
        {
            /*
            *   try
            *   {
            *       Date date = format.parse(fecha.getText().toString());
            *       Toast.makeText(this, fecha, Toast.LENGTH_SHORT).show();
            *       text.setText("");
            *    }
            *    catch(ParseException e)
            *   {
            *       Toast.makeText(this, R.string.mensaje_error, Toast.LENGTH_SHORT).show();
            *   }
            * */
            if (validarFecha(fecha))
            {
                Toast.makeText(this, fecha, Toast.LENGTH_SHORT).show();
            }
            else if (!validarFecha(fecha))
            {
                Toast.makeText(this, R.string.mensaje_error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean validarFecha(String fecha)
    {
        try
        {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        }
        catch (ParseException e) {
            return false;
        }
        return true;
    }
}