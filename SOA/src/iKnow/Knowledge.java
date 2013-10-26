package iKnow;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Knowledge {
	private HashMap<String,List<String>> know;
	
	public Knowledge () {
		know = new HashMap<String, List<String>>();
	}
	
	public Knowledge (HashMap<String,List<String>> know) {
		this.know = know;
	}
	
	public void add(String key, String value) {
		if(know.containsKey(key) == false) {
			ArrayList<String> valuel = new ArrayList<String>();
			valuel.add(value);
			know.put(key,valuel);
		}
		else {
			know.get(key).add(value);
		}
	}
	
	public List<String> getEntry(String key) {
		return(know.get(key));		
	}
}
