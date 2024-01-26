package com.example.pm_mysql.clases;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

public class Juego implements Serializable{
	private final String identificador;
	private final String plataforma;
	private final String nombreJuego;
	private final String genero;
	private final double precioJuego;

	public Juego(String identificador, String plataforma, String nombreJuego, String genero,
				 double precioJuego){
		this.identificador = identificador;
		this.plataforma = plataforma;
		this.nombreJuego = nombreJuego;
		this.genero = genero;
		this.precioJuego = precioJuego;
	}

	public String getIdentificador(){
		return identificador;
	}

	public String getPlataforma(){
		return plataforma;
	}

	public String getNombreJuego(){
		return nombreJuego;
	}

	public String getGenero(){
		return genero;
	}

	public double getPrecioJuego(){
		return precioJuego;
	}

	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		Juego juego = (Juego) o;
		return identificador.equals(juego.identificador);
	}

	@Override
	public int hashCode(){
		return Objects.hash(identificador);
	}

	@NonNull
	@Override
	public String toString(){
		return "Juego{" + "identificador='" + identificador + '\'' + ", plataforma='" + plataforma +
			   '\'' + ", nombreJuego='" + nombreJuego + '\'' + ", genero='" + genero + '\'' +
			   ", precioJuego=" + precioJuego + '}';
	}
}
