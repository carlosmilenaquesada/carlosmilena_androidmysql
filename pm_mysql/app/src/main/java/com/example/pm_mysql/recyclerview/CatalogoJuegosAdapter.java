package com.example.pm_mysql.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm_mysql.R;
import com.example.pm_mysql.clases.ConfiguracionDB;
import com.example.pm_mysql.clases.Juego;
import com.example.pm_mysql.utilidades.ImagenesBlobBitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CatalogoJuegosAdapter extends RecyclerView.Adapter<JuegoViewHolder>{
	private final Context contexto;
	private ArrayList<Juego> juegos;
	private final LayoutInflater inflate;

	public CatalogoJuegosAdapter(Context contexto, ArrayList<Juego> juegos){
		this.contexto = contexto;
		this.juegos = juegos;
		inflate = LayoutInflater.from(this.contexto);
	}

	@NonNull
	@Override
	public JuegoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
		View mItemView = inflate.inflate(R.layout.item_rv_juego, parent, false);
		return new JuegoViewHolder(mItemView, this);
	}

	public Context getContexto(){
		return contexto;
	}

	public ArrayList<Juego> getJuegos(){
		return juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos){
		this.juegos = juegos;
		notifyDataSetChanged();
	}

	@Override
	public void onBindViewHolder(@NonNull JuegoViewHolder holder, int position){
		Juego j = this.getJuegos().get(position);
		holder.getTvItemIdentificador().setText(j.getIdentificador());
		holder.getTvItemPlataforma().setText(j.getPlataforma());
		holder.getTvItemNombreJuego().setText(j.getNombreJuego());
		holder.getTvItemGenero().setText(j.getGenero());
		holder.getTvItemPrecioVenta().setText(String.valueOf(j.getPrecioJuego()));
		String idimagen = j.getIdentificador();
		descargarImagen(idimagen, holder.getIvItemImagen(), contexto);
	}

	private void descargarImagen(String idimagen, ImageView imageView, Context contexto){
		StringRequest request = new StringRequest(Request.Method.POST,
				ConfiguracionDB.DIRECCION_URL_RAIZ +
				"/mostrar-foto.php", new Response.Listener<String>(){
			@Override
			public void onResponse(String response){
				try{
					JSONObject jsonObject = new JSONObject(response);
					String exito = jsonObject.getString("exito");
					JSONArray jsonArray = jsonObject.getJSONArray("imagenes");
					if(exito.equals("1")){
						int cuantos = jsonArray.length();
						if(cuantos > 0){
							JSONObject object = jsonArray.getJSONObject(0);
							String imagen = object.getString("imagen");
							byte[] fotobyte = ImagenesBlobBitmap.string_to_byte(imagen);
							Bitmap fotobitmap = ImagenesBlobBitmap.bytes_to_bitmap(fotobyte, 500,
									500);
							imageView.setImageBitmap(fotobitmap);
						}else{
							imageView.setImageResource(R.drawable.imagen_no_disponible);
						}
					}
				}catch(JSONException ex){
					throw new RuntimeException(ex);
				}
			}
		}, new Response.ErrorListener(){
			@Override
			public void onErrorResponse(VolleyError error){
			}
		}){
			@Override
			protected Map<String, String> getParams(){
				Map<String, String> params = new HashMap<>();
				params.put("idimagen", idimagen);
				return params;
			}
		};
		RequestQueue requestQueue = Volley.newRequestQueue(contexto);
		requestQueue.add(request);
	}

	@Override
	public int getItemCount(){
		return this.juegos.size();
	}
}
