import java.util.ArrayList;
import java.util.List;
/*Añadimos este comentario para la prueba del commit y psuh de el examen final*/ 
public class tiempo {
    String estacion;
	String ciudad;
	String porcentaje_humedad;
	String temperatura;
	String velocidad;
	String fecha;
	String hora;
	public cotizacion(){
		
	}

	public tiempo(String estacion, String ciudad, String porcentaje_humedad, String temperatura, String velocidad, String fecha,String hora){
		this.estacion = estacion;
		this.ciudad = ciudad;
		this.porcentaje_humedad = porcentaje_humedad;
		this.temperatura=temperatura;
		this.velocidad=velocidad;
		this.fecha=fecha;
		this.hora=hora;
	}
	
	public String getEstacion() {
		return estacion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getHumedad() {
		return porcentaje_humedad;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public String getVelocidad() {
		return velocidad;
	}
	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setHumedad(String porcentaje_humedad) {
		this.porcentaje_humedad = porcentaje_humedad;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public void setVelocidad(String velocidad) {
		this.velocidad= velocidad;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora= hora;
	}
	
}