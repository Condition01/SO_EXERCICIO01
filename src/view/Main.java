package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redeCont = new RedesController();
		String so,path;
		so = redeCont.so();
		path = "ipconfig";
		System.out.println(so);
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para revelar os Adaptadores de internet com IPV4"));
			switch(opc) {
			case 1: redeCont.mostraEthernet(path, so);
				break;
			case 2:
				break;
			case 9: System.exit(0);
				break;
			}
		}while(opc!=9);
	}

}
