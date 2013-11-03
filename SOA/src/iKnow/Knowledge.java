package iKnow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Knowledge {
	private HashMap<String,String> know;
	
	public Knowledge () {
		know = new HashMap<String, String>();
		load();
	}
	
	public Knowledge (HashMap<String,String> know) {
		this.know = know;
	}
	
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
	}
	
	public String getEntry(String key) {
		return(know.get(key));		
	}
	
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
