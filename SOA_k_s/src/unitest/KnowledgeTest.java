package unitest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import iKnow.Knowledge;

import org.junit.Before;
import org.junit.Test;


public class KnowledgeTest {

	Knowledge know;
	
	
	/**
	 * Hier wird die ein Objekt der Klasse initialisiert das muss am Anfang passieren
	 */
	@Before
	public void setUp() {
		know = new Knowledge();
	}
	
	/**
	 * Test des zweiten Konstruktors
	 * Erwarteter Rueckgabewert: Hallo
	 * Rueckgabewert: Hallo
	 */
	@Test
	public void konstruktorTest() {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("Hallo", "Hallo");
		know = new Knowledge(map);
		assertEquals(know.getEntry("Hallo"),"Hallo");
	}
	
	
}
