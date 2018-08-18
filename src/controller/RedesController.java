package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JOptionPane;

public class RedesController {
	public RedesController() {
		super();
	}
	public String so() {
		return System.getProperty("os.name");
	}
	public void mostraEthernet(String so) {
		
		if(so.equals("Windows 10")) {
			String path = "ipconfig";
			try {
				String vetFrase[] = new String[2];
				Process proc = Runtime.getRuntime().exec(path);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();			
				while(linha != null) {
					if(linha.contains("Adaptador")) {							
						vetFrase[0] = linha;
						linha = buffer.readLine();
					}
					else {
						if(linha.contains("IPv4")) {							
							vetFrase[1] =  linha;
							System.out.println(vetFrase[0] + "\n" + vetFrase[1]);
						}
						linha = buffer.readLine();
					}
				}
			} catch (IOException e) {
				String erro = e.getMessage();
				JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
		}
		else if(so.equals("Linux")) { // precisa de alguns acertos
			String path = "ifconfig";
				try {
					String vetFrase[] = new String[2];
					Process proc = Runtime.getRuntime().exec(path);
					InputStream fluxo = proc.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();			
					while(linha != null) {						
						if(linha.contains("mtu")) {
							vetFrase[0] = linha;							
						}
						else if(linha.contains("inet") && !(linha.contains("inet6"))) {														
							vetFrase[1] =  linha;
							System.out.println(vetFrase[0] + "\n" + vetFrase[1]);
						}
						linha = buffer.readLine();
					}
				} catch (IOException e) {
					String erro = e.getMessage();
					JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}		
		}
	}	
	/*StringBuffer buffer = new StringBuffer();
	double tempoInicial = System.nanoTime();
	for (int i = 0; i < 32768; i++) {
		buffer.append("");
	}
	double tempoFinal = System.nanoTime();
	double tempoGasto = tempoFinal - tempoInicial;
	tempoGasto = tempoGasto / Math.pow(10, 9);
	System.out.println("String ==>" + tempoGasto + " segundos");*/
	
	
	/*String[] vetFrase = frase.split(" ");
		for(String palavra: vetFrase){
			System.out.println(palavra);
		}*/
	
	
}
