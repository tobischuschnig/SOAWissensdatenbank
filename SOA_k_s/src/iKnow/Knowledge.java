package iKnow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Ist das Model zum speichern und hinzufuegen von Elementen der Hashmap
 * Arbeiet mit der Klasse Proberties zum persistenten speichern
 * @author Schuschnig Klune
 * @version 2013-11-04
 *
 */
public class Knowledge {
	private HashMap<String,String> know;
	
	/**
	 * Der Standart-Konstruktort
	 */
	public Knowledge () {
		know = new HashMap<String, String>();
		load();
	}
	
	/**
	 * Initialisieren mit einer vorhanden Wissensdatenbank
	 * @param know Hashmap der Wissensdatenbank
	 */
	public Knowledge (HashMap<String,String> know) {
		this.know = know;
	}
	
	/**
	 * Fuegt einen Eintrag der Wissensdatenbank hinzu
	 * @param key String das Topic wird als Key gespeichert
	 * @param value String der Content wird als value gespeichert
	 * @return Rueckgabe ob das speichern funktioniert hat
	 */
	public boolean add(String key, String value) {
		if(know.containsKey(key) == false) {
			know.put(key,value);
		}
		else {
			String hilf = know.get(key) + "\n" + value;
			know.remove("key");
			know.put(key, hilf);
		}
		boolean bool = save();
		
		return bool;
//		return true;
	}
	
	/**
	 * Suche nach einem Topic
	 * @param key String das zu suchende Topic
	 * @return Rueckgbe der Content zu dem Topic
	 */
	public String getEntry(String key) {
		return(know.get(key));		
	}
	
	/**
	 * Speichert die Wissensdatenbank mittels Proberties
	 * @return ob das speichern funktioniert hat
	 */
	public boolean save() {
		Properties properties = new Properties();
		Iterator it = know.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        properties.setProperty((String)pairs.getKey(), (String)pairs.getValue());
	    }
		
		FileWriter writer;
		try {
			writer = new FileWriter("conf.properties");
			properties.store(writer, null);
			writer.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	 * Ladet eine Wissensdatenbank
	 * @return ob das Laden funktioniert hat
	 */
	public boolean load() {
		Properties properties = new Properties();
		FileReader reader;
		try {
			reader = new FileReader("conf.properties");
			properties.load(reader);
		} catch (FileNotFoundException e1) {
			return false;
		} catch (IOException e) {
			return false;
		}
		for (final String name: properties.stringPropertyNames())
		    know.put(name, properties.getProperty(name));
		return true;
	}
}
