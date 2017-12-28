import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;
/**
 * 
 * @author Jonathan
 *
 */
public class main_w extends JFrame{
	
	public main_w(){
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		main_w window = new main_w();
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//window.pack();
		//window.setTitle("Easy Folder Name'er");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
