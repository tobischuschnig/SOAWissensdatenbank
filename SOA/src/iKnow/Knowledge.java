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
	
	@SuppressWarnings("unused")
	private void add(String key, String value) {
		if(know.containsKey(key) == false) {
			ArrayList<String> valuel = new ArrayList<String>();
			know.put(key,valuel);
			
		}
		else {
			know.get(key).add(value);
		}
	}
	
	@SuppressWarnings("unused")
	private List<String> getEntry(String key) {
		return(know.get(key));		
	}
}
