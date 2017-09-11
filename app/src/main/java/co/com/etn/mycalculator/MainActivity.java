package co.com.etn.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextResultado;
    EditText editText1, editText2;
    RadioGroup radioOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextResultado = (EditText) findViewById(R.id.editTextResultado);
        radioOperacion = (RadioGroup) findViewById(R.id.operacion);

        radioOperacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ejecutar();
            }
        });

        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ( keyEvent.getAction() == KeyEvent.ACTION_UP )
                    ejecutar();
                return false;
            }
        });

        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ( keyEvent.getAction() == KeyEvent.ACTION_UP )
                    ejecutar();
                return false;
            }
        });

    }

    public void ejecutar(){
        double n1 = Double.parseDouble( editText1.getText().toString().equals("") ? "0" : editText1.getText().toString() );
        double n2 = Double.parseDouble( editText2.getText().toString().equals("") ? "0" : editText2.getText().toString() );
        int radioButtonID = radioOperacion.getCheckedRadioButtonId();
        if( radioButtonID == R.id.radioButtonSumar )
            editTextResultado.setText( String.valueOf(n1+n2) );
        if( radioButtonID == R.id.radioButtonMultiplicar )
            editTextResultado.setText( String.valueOf(n1*n2) );
        if( radioButtonID == R.id.radioButtonRestar )
            editTextResultado.setText( String.valueOf(n1-n2) );
        if( radioButtonID == R.id.radioButtonDividir ) {
            if( n2==0 )
                editTextResultado.setText("NA");
            else
                editTextResultado.setText(String.valueOf(n1/n2));
        }
        //Toast.makeText(this,editTextResultado.getText(),Toast.LENGTH_SHORT).show();
    }

}
