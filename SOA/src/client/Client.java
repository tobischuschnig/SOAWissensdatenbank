package client;

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
			System.out.println(n);
			if(n==1) { //Suchen
				know.getEntry(String);
			}
			else if(n==2) {//Beitrag erstellen
				
			}
		}
			
	}

}
