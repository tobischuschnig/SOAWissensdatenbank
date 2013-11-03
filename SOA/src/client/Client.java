package client;

import java.util.List;

import javax.swing.JOptionPane;

import iKnow.Knowledge;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Knowledge know = new Knowledge();
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
				String value = know.getEntry(key);
				if(value != null) {
					JOptionPane.showMessageDialog(null, key+"\n\n"+value, "Thema: "+key,1);
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
						know.add(key, value);
						JOptionPane.showMessageDialog(null, "Beitrag wurde erstellt." , "Succes",1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Beitrag konnte nicht ewrstellt werden." , "Error",1);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Beitrag konnte nicht ewrstellt werden." , "Error",1);
				}
			}
		}
			
	}

}
