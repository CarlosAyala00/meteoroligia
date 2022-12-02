import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class cotizacionJSON {


    public static void main(String[] args) throws Exception {
    	
    }
    
    public static String objetoString(cotizacion p) {	
    	
		JSONObject obj = new JSONObject();
        obj.put("Estacion", p.getEstacion());
        obj.put("Ciudad", p.getCiudad());
        obj.put("Porcentaje Humedad", p.getHumedad());
        obj.put("Temperatura", p.getTemperatura());
        obj.put("Velocidad Viento", p.getVelocidad());
        obj.put("Fecha", p.getFecha());
        obj.put("Hora", p.getHora());
        return obj.toJSONString();
    }
    
    
    public static cotizacion stringObjeto(String str) throws Exception {
    	cotizacion p = new cotizacion();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(str.trim());
        JSONObject jsonObject = (JSONObject) obj;
        p.setEstacion((String)jsonObject.get("Estacion"));
        p.setCiudad((String)jsonObject.get("Ciudad"));
        p.setHumedad((String)jsonObject.get("Porcentaje Humedad"));
        p.setTemperatura((String)jsonObject.get("Temperatura"));
        p.setVelocidad((String)jsonObject.get("Velocidad Viento"));
        p.setFecha((String)jsonObject.get("Fecha"));
        p.setHora((String)jsonObject.get("Hora"));
        
        return p;
	}

}
