import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
/**
 * 
 * @author Jonathan
 *
 */
public class main_w extends JFrame{
	
	public main_w(){
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
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
