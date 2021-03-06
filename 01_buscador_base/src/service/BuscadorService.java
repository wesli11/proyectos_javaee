package service;

import java.util.ArrayList;
import java.util.List;

import model.Item;

public class BuscadorService {
	List<Item> items=List.of(new Item("Casa del libro","http://casadellibro.es", new String[]{"libros","lectura","ocio"},"Libros y m�s cosas"),
			new Item("La web del gamer","http://gamers.es", new String[]{"juegos","ordenadores","ocio"},"Todo sobre video juegos"),
			new Item("My computer","http://computerall.es", new String[]{"inform�tica","ordenadores"},"Ordenadores al mejor precio"),
			new Item("Fnac","http://fnac.es", new String[]{"juegos","ordenadores","libros"},"Bienvenido al mundo del ocio y la cultura"),
			new Item("Todo pelis","http://filmers.es", new String[]{"cine","peliculas","ocio"},"Entra en el mundo del cine"));
	
	public List<Item> buscarItems(String tema){
		List<Item> resultado=new ArrayList<>();
		if(comprobar(tema)) {
			//recorremos todos los item de la lista
			for(var item:items) {
				//para cada item, recorremos su array de temas
				//y miramos si alguno coincide con el tema recibido
				for(var dato:item.getSeo()) {
					if(dato.equals(tema)) {
						resultado.add(item);
					}
				}
			}
			return resultado;
		}
		return null;
	}
	
	private boolean comprobar(String palabra) {
		for(Item item:items) {
			for(String dato:item.getSeo()) {
				if(dato.equals(palabra)) {
					return true;
				}
			}
		}
		return false;
	}
}
