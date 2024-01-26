package com.example.pm_mysql;

import static com.example.pm_mysql.AutenticacionActivity.EMAIL_KEY;
import static com.example.pm_mysql.AutenticacionActivity.SHARED_PREFS;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuGeneralActivity extends AppCompatActivity{
	TextView tvSaludoAlUsuario;

	@Override
	protected void onStart(){
		super.onStart();
		SharedPreferences sharedpreferences =
				getSharedPreferences(AutenticacionActivity.SHARED_PREFS, Context.MODE_PRIVATE);
		String email = sharedpreferences.getString(AutenticacionActivity.EMAIL_KEY, null);
		String password = sharedpreferences.getString(AutenticacionActivity.PASSWORD_KEY, null);
		if(email == null || password == null){
			Toast.makeText(getApplicationContext(), "No tienes permiso para esta sección", Toast.LENGTH_SHORT).show();
			startActivity(new Intent(getApplicationContext(), AutenticacionActivity.class));
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_general);
		tvSaludoAlUsuario = (TextView) findViewById(R.id.tvSaludoAlUsuario);
		String usuario =
				getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE).getString(EMAIL_KEY,
						"anónimo");
		tvSaludoAlUsuario.setText(getString(R.string.saludo, usuario));
	}

	public void irAInsertarJuegoConFoto(View view){
		startActivity(new Intent(this, AgregarNuevoJuegoActivity.class));
	}

	public void irAMostrarDatos(View view){
		startActivity(new Intent(this, MostrarCatalogoActivity.class));
	}

	public void salirDeMenuGeneral(View view){
		startActivity(new Intent(this, AutenticacionActivity.class));
	}

	public void cerrarAplicacion(View view){
		finishAffinity();
		System.exit(0);
	}
}