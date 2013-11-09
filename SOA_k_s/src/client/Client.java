package client;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import org.apache.axis2.AxisFault;

import iknowsoa.KnowledgeServiceStub;
import iknowsoa.KnowledgeServiceStub.*; 

/**
 * Der Client zur Wissensdatenbank realisiert mittels eines JMessageDialog
 * @author Schuschnig Klune
 * @version 2013-11-02
 */
public class Client {

	/**
	 * @param args
	 * @throws AxisFault 
	 */
	public static void main(String[] args) throws RemoteException{
		
			KnowledgeServiceStub stub = new KnowledgeServiceStub();
			int n = 2; 
		while(n != -1 && n != 0) {
			Object[] options = {"Schliessen",
			                    "Suchen",
			                    "Beitrag erstellen"};
			n = JOptionPane.showOptionDialog(null,
			    "Was wollen sie tun?",
			    "Knowledge",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    
			    options,
			    options[2]);
			if(n==1) { //Suchen
				String key = (String)JOptionPane.showInputDialog("Geben sie das Thema ein: ");
				GetEntry ge = new GetEntry();
				ge.setKey(key);
				GetEntryResponse ger = stub.getEntry(ge);
				
//				String value = know.getEntry(key);
				if(ger != null) {
					JOptionPane.showMessageDialog(null, key+"\n\n"+ger.getGetEntryReturn(), "Thema: "+key,1);
				}
				else {
					JOptionPane.showMessageDialog(null, "Beitrag muss erstellt werden." , "Error",1);
				}
			}
			else if(n==2) {//Beitrag erstellen
				String key = (String)JOptionPane.showInputDialog("Geben sie das Thema ein:");
				if (key != null) {
					String value = (String)JOptionPane.showInputDialog("Geben sie den Text dazu ein: ");
					if (value != null) { 
						Add a = new Add();
						a.setKey(key);
						a.setValue(value);
						stub.add(a);
//						know.add(key, value);
						JOptionPane.showMessageDialog(null, "Beitrag wurde erstellt." , "Succes",1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Beitrag konnte nicht erstellt werden." , "Error",1);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Beitrag konnte nicht erstellt werden." , "Error",1);
				}
			}
		}
	
	}

}
