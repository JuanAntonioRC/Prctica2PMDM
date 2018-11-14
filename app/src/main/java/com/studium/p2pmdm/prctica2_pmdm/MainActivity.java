package com.studium.p2pmdm.prctica2_pmdm;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //spinner

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCivilStatus);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.SpinnerCivilStatus, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        final TextView inputName = findViewById(R.id.inputName);
        final TextView inputSurname = findViewById(R.id.inputSurname);
        final TextView inputAge = findViewById(R.id.inputAge);
        RadioButton radioButtonMen = findViewById(R.id.radialButtonMen);
        RadioButton radioButtonWomen = findViewById(R.id.radialButtonWomen);
        final Spinner spinnerCivilStatus = findViewById(R.id.spinnerCivilStatus);
        final Switch switchHijos = findViewById(R.id.switchHijos);
        Button buttonResumen = findViewById(R.id.ButtonResumen);
        ImageButton clearButton = findViewById(R.id.clearButton);
        final TextView resultadoResumen = findViewById(R.id.resultadoResumen);
        final RadioButton radialButtonMen = findViewById(R.id.radialButtonMen);
        final RadioButton radialButtonWomen = findViewById(R.id.radialButtonWomen);


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName.setText("");
                inputSurname.setText("");
                inputAge.setText("");
                radialButtonMen.setChecked(false);
                radialButtonWomen.setChecked(false);
                switchHijos.setChecked(false);
                resultadoResumen.setText("");
                spinnerCivilStatus.setSelection(0);
                inputName.setHint(getResources().getString(R.string.inputNameHint));
                inputSurname.setHint(getResources().getString(R.string.inputSurnameHint));
                inputAge.setHint(getResources().getString(R.string.inputAgeHint));
                inputName.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                inputSurname.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                inputAge.setHintTextColor(getResources().getColor(R.color.colorPrimary));

            }
        });

        buttonResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = inputName.getText().toString();
                String apellido = inputSurname.getText().toString();
                String edad = inputAge.getText().toString();
                String mayorDeEdad = null;
                String hijos;
                String civilStatus = spinnerCivilStatus.getSelectedItem().toString();
                String Sexo;

                if (radialButtonMen.isChecked()){

                    Sexo = getResources().getString(R.string.radialButtonMen);
                } else {

                    Sexo = getResources().getString(R.string.radialButtonWomen);
                }


                if (edad.length() != 0){

                    int edadNumero = Integer.parseInt(edad);

                    if (edadNumero < 18){

                        mayorDeEdad = getResources().getString(R.string.mayorDeEdadNegativo);

                    } else {

                        mayorDeEdad = getResources().getString(R.string.mayorDeEdadPositivo);
                    }
                }


                if (switchHijos.isChecked()) {


                    hijos = getResources().getString(R.string.hijosPositivo);

                } else {

                    hijos = getResources().getString(R.string.hijosNegativo);
                }
                resultadoResumen.setText(apellido + ", " + nombre + ", " + mayorDeEdad + ", " + Sexo + " " + civilStatus + ", " + hijos);



                //ahora se realizan las comprobaciones y si se debe de cambiar los espacios en blanco por mensajes de error



                if (inputName.getText().toString().isEmpty()){


                    resultadoResumen.setText(apellido + ", " + getResources().getString(R.string.errorName) + ", " +  mayorDeEdad + ", " + Sexo + " " + civilStatus + ", " + hijos );
                    inputName.setHint(getResources().getString(R.string.errorName));
                    inputName.setHintTextColor(getResources().getColor(R.color.Error));

                }

                if (inputSurname.getText().toString().isEmpty()){


                    resultadoResumen.setText(getResources().getString(R.string.errorSurname) + ", " + nombre + ", " + mayorDeEdad + ", " + Sexo + " " + civilStatus + ", " + hijos);
                    inputSurname.setHint(getResources().getString(R.string.errorSurname));
                    inputSurname.setHintTextColor(getResources().getColor(R.color.Error));

                }

                if (inputAge.getText().toString().isEmpty()){


                    resultadoResumen.setText(apellido + ", " + nombre + ", " + getResources().getString(R.string.errorAge) + ", " + Sexo + " " + civilStatus + ", " + hijos);
                    inputAge.setHint(getResources().getString(R.string.errorAge));
                    inputAge.setHintTextColor(getResources().getColor(R.color.Error));

                }

                if (inputName.getText().toString().isEmpty() && inputSurname.getText().toString().isEmpty()) {

                    resultadoResumen.setText(getResources().getString(R.string.errorName) + ", " + getResources().getString(R.string.errorSurname) + ", " + mayorDeEdad + ", " + Sexo + " " + civilStatus + ", " + hijos);

                }

                if (inputName.getText().toString().isEmpty() && inputAge.getText().toString().isEmpty()){

                    resultadoResumen.setText(apellido + ", " + getResources().getString(R.string.errorName) + ", " + getResources().getString(R.string.errorAge) + ", " + Sexo + " " + civilStatus + ", " + hijos);

                }

                if (inputSurname.getText().toString().isEmpty() && inputAge.getText().toString().isEmpty()){

                    resultadoResumen.setText(getResources().getString(R.string.errorSurname) + ", " + nombre +getResources().getString(R.string.errorAge) + ", " + Sexo + " " + civilStatus + ", " + hijos);
                }

                if (inputName.getText().toString().isEmpty() && inputAge.getText().toString().isEmpty() && inputSurname.getText().toString().isEmpty()) {


                    resultadoResumen.setText(getResources().getString(R.string.errorSurname) + ", " + getResources().getString(R.string.errorName) + ", " + getResources().getString(R.string.errorAge) + ", " + Sexo + " " + civilStatus + ", " + hijos);

                }
            }
        });


    }

}
