package client;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class XMLElemente {

	  @XmlElement 
	  public String  key;
	  
	  @XmlElement
	  public List<String> value;

	  private XMLElemente() {
		  
	  } //Benoetigt von JAXB

	  public XMLElemente(String key, List<String> value) {
	    this.key   = key;
	    this.value = value;
	  }

}
