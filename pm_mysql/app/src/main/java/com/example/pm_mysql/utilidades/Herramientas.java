package com.example.pm_mysql.utilidades;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm_mysql.clases.ConfiguracionDB;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Herramientas{
	public static void rellenarSpinnerConInfoBd(Context contexto, ArrayAdapter<String> adapter,
												String nombreTablaDelContenidoDB,
												String nombreColumnaContenidoDb,
												String nombreArchivoPhp){
		StringRequest request = new StringRequest(Request.Method.POST,
				ConfiguracionDB.DIRECCION_URL_RAIZ +
				nombreArchivoPhp, new Response.Listener<String>(){
			@Override
			public void onResponse(String response){
				adapter.clear();
				ArrayList<String> listaValores = new ArrayList<>();
				try{
					JSONObject jsonObject = new JSONObject(response);
					String exito = jsonObject.getString("exito");
					JSONArray jsonArray = jsonObject.getJSONArray(nombreTablaDelContenidoDB);
					if(exito.equals("1")){
						for(int i = 0; i < jsonArray.length(); i++){
							JSONObject object = jsonArray.getJSONObject(i);
							String contenidoColumna = object.getString(nombreColumnaContenidoDb);
							listaValores.add(contenidoColumna);
						}
						adapter.addAll(listaValores);
						adapter.notifyDataSetChanged();
					}
				}catch(JSONException ex){
					throw new RuntimeException(ex);
				}
			}
		}, new Response.ErrorListener(){
			@Override
			public void onErrorResponse(VolleyError error){
				Toast.makeText(contexto, error.getMessage(), Toast.LENGTH_SHORT).show();
			}
		}){
		};
		RequestQueue requestQueue = Volley.newRequestQueue(contexto);
		requestQueue.add(request);
	}
}
