package com.example.act1_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton = findViewById(R.id.loginButton);



    private EditText usernameEditText;
    private EditText passwordEditText;

    private CheckBox savePasswordCheckBox;
    private static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        savePasswordCheckBox = findViewById(R.id.savePasswordCheckBox);

        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Verificar si el nombre de usuario y la contraseña son correctos
                if (username.equals("usuario") && password.equals("contraseña")) {
                    // Mostrar mensaje de bienvenida
                    String welcomeMessage = "¡Bienvenido, " + username + "!";
                    Toast.makeText(MainActivity.this, welcomeMessage, Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar mensaje de error si las credenciales son incorrectas
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                String savedUsername = settings.getString("username", "");
                String savedPassword = settings.getString("password", "");

                usernameEditText.setText(savedUsername);
                passwordEditText.setText(savedPassword);
                if (savePasswordCheckBox.isChecked()) {
                    // Guardar las credenciales en las preferencias compartidas
                    SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, 0).edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                }
                // Realizar la autenticación aquí
                // Si las credenciales son válidas, muestra un mensaje de bienvenida
                if (username.equals("usuario") && password.equals("contraseña")) {
                    String welcomeMessage = "¡Bienvenido, " + username + "!";
                    Toast.makeText(MainActivity.this, welcomeMessage, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, Tienda.class);
                startActivity(intent);



            }
        });
    }
}