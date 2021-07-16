package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
		
		private AnagrammaDAO anagrammaDAO;
		
		
		public Model() {
			this.anagrammaDAO = new AnagrammaDAO();
		}
		
		public boolean isCorrect(String anagramma){
			return anagrammaDAO.isCorrect(anagramma);
		}
		
		 public List<String> anagrammi(String anagramma) {
				
				List<String> risultato = new ArrayList<>() ;
				permuta("", anagramma, 0, risultato) ; 
			
				return risultato ;
				
			}
			
			private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
				if( lettere.length()==0 ) {
				
					risultato.add(parziale) ;
				} else {
					for(int pos=0; pos<lettere.length(); pos++) {
						
						char tentativo = lettere.charAt(pos) ; 
						
						String nuovaParziale = parziale + tentativo ;
						String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
							
						permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;
						
				
				}
			}
			}
		
}
