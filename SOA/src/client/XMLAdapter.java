package client;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XMLAdapter extends XmlAdapter<XMLElemente [], HashMap<String, List<String>>> {
	//XMLELemente ist dabei der ValueType und HashMap<String, List<String>> der BoundType
	@Override
	public XMLElemente[] marshal(HashMap<String, List<String>> elemente)
			throws Exception {
		XMLElemente[] xmle = new XMLElemente[elemente.size()];
		
		for(int i = 0; i < elemente.size();i++) {
			Map.Entry<String, List<String>> el = elemente.getEntry(i);
			xmle[i] = new XMLElemente(el.getKey(),el.getValue());
		}
		
		return xmle;
	}

	@Override
	public HashMap<String, List<String>> unmarshal(XMLElemente[] arg0)
			throws Exception {
		
		return null;
	}

}
