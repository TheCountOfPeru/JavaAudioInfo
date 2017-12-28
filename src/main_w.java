import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
/**
 * 
 * @author Jonathan
 *
 */
public class main_w extends JFrame{
	
	public main_w(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnClearAll = new JButton("Clear All");
		GridBagConstraints gbc_btnClearAll = new GridBagConstraints();
		gbc_btnClearAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnClearAll.gridx = 0;
		gbc_btnClearAll.gridy = 0;
		getContentPane().add(btnClearAll, gbc_btnClearAll);
		
		JButton btnCopyToClipboard = new JButton("Copy to Clipboard");
		GridBagConstraints gbc_btnCopyToClipboard = new GridBagConstraints();
		gbc_btnCopyToClipboard.insets = new Insets(0, 0, 5, 0);
		gbc_btnCopyToClipboard.gridx = 1;
		gbc_btnCopyToClipboard.gridy = 0;
		getContentPane().add(btnCopyToClipboard, gbc_btnCopyToClipboard);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		getContentPane().add(textArea, gbc_textArea);
		
	}
	public static void main(String[] args) {
		main_w window = new main_w();
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setSize(1000, 1000);
		//window.pack();
		window.setTitle("Easy Folder Name'er");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
