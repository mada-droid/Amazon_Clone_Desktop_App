package espanelstyle;


import javax.swing.JFrame;

/**
 * Classe che mette il nostro login panel dentro un frame che potrebbe essere chiamato succeissivamente 
 * @author Mohamed Marzouk
 *
 */
public class Home extends JFrame {
	
	public Home() {
		super("HomeScreen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginPage panelloPrimo = new LoginPage();
		add(panelloPrimo);
		setBounds(0,0, 600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
