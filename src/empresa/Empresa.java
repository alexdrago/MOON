package empresa;


import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import trabajadores.Trabajador;

@SuppressWarnings("serial")
public class Empresa implements Serializable {
	
	
	TreeMap<String , Trabajador> plantilla;
	TreeMap<String , Centro> centros;
	TreeMap<String, Tecnologia> tecnologias;
	
	/**
	 * @author alejandro
	 * Constructor de clase de empresa por defecto
	 */
	public Empresa() {
		
		plantilla=new TreeMap <String,Trabajador>();
		centros=new TreeMap<String,Centro>();
		tecnologias=new TreeMap<String,Tecnologia>();
	}

	/**
	 * Obteber el objeto plantilla
	 * @return el plantilla
	 */
	public TreeMap <String,Trabajador> getPlantilla() {
		return plantilla;
	}

	/**
	 * Modificar toda la plantilla
	 * @param plantilla el plantilla a establecer
	 */
	public void setPlantilla(TreeMap <String,Trabajador> plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * Obteber el centro
	 * @return el centros
	 */
	public Centro getCentro(Centro buscado) {
		centros.get(buscado.getCodigo());
		return null;
	}
	
	/**
	 * Establecer el conjunto de centros por completo, de la empresa. 
	 * @param Treemap del conjunto de centros a poner.
	 */
	public void setCentros(TreeMap<String,Centro> centros) {
		this.centros = centros;
	}
	/**
	 * obtener el conjunto de centros por completo, de la empresa. 
	 * @param Treemap del conjunto de centros a obtener.
	 */
	public TreeMap<String , Centro> getCentros() {
		return this.centros;
	}
	
	public void aņadirCentro(Centro centro_aniadido) {
		this.centros.put(centro_aniadido.getCodigo(), centro_aniadido);
	}
	public void borraCentro(String borrado) {
		this.centros.remove(borrado);
	}


	/**
	 * @return el tecnologias
	 */
	public TreeMap<String, Tecnologia> getTecnologias() {
		return tecnologias;
	}

	/**
	 * @param tecnologias el tecnologias a establecer
	 */
	public void setTecnologias(TreeMap<String,Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}
	
		 
	public void altaTrabajador(Trabajador T,TreeMap <String,Trabajador> plantilla) {
		plantilla.put(T.getDni(), T);

	}
	public void bajaTrabajador(Trabajador T,TreeMap <String,Trabajador> plantilla) {
		plantilla.remove(T.getDni(), T);

	}
		
	public Empresa LeerEmpresa() throws FileNotFoundException, IOException, ClassNotFoundException{
		//Leer el objeto guardado
		
		 ObjectInputStream leido = new ObjectInputStream(new FileInputStream("Empresa.txt"));
				return (Empresa)leido.readObject();
				
	}
	
	public void GrabaEmpresa(Empresa o) throws FileNotFoundException, IOException{
		ObjectOutputStream guardado= new ObjectOutputStream(new FileOutputStream("Empresa.txt"));
			guardado.writeObject (o);
	}
	
	public void listarCentros(){
		for (Entry<String, Centro> centro : centros.entrySet()) {
			Centro C=centro.getValue();
			System.out.println(C.datosCompletos());
		}
		
		
	}

	
	
}
