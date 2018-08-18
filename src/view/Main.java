package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redeCont = new RedesController();
		String so;
		so = redeCont.so();
		System.out.println(so);
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para revelar os Adaptadores de internet com IPV4" 
									+ "\nDigite 2 para ver a media de ping após 10 segundos" + "\nDigite 9 para sair"));
			switch(opc) {
			case 1: redeCont.mostraEthernet(so);
				break;
			case 2: redeCont.pingDez(so);
				break;
			case 9: System.exit(0);
				break;
			}
		}while(opc!=9);
	}

}
