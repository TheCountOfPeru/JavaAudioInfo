import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextArea;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Jonathan
 *
 */
public class main_w extends JFrame{
	private Vector<String> vlist;
	public main_w(){
		
		vlist = new Vector<String>(0);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
			
		
		JTextArea myList = new JTextArea();
		myList.setEditable(false);
		myList.setToolTipText("DROP FILES HERE");
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		getContentPane().add(myList, gbc_textArea);
		
		 new FileDrop( myList, new FileDrop.Listener()
         {   public void filesDropped( java.io.File[] files )
             {   
        	 for( int i = 0; i < files.length; i++ )
             {   try
                 {   myList.append( files[i].getCanonicalPath() + "\n" );
                 }   // end try
                 catch( java.io.IOException e ) {}
             }   // end for: through each dropped file			
  				 			
             }   // end filesDropped
         });
		
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnClearAll = new GridBagConstraints();
		gbc_btnClearAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnClearAll.gridx = 0;
		gbc_btnClearAll.gridy = 0;
		getContentPane().add(btnClearAll, gbc_btnClearAll);
		
		JButton btnCopyToClipboard = new JButton("Copy to Clipboard");
		btnCopyToClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnCopyToClipboard = new GridBagConstraints();
		gbc_btnCopyToClipboard.insets = new Insets(0, 0, 5, 0);
		gbc_btnCopyToClipboard.gridx = 1;
		gbc_btnCopyToClipboard.gridy = 0;
		getContentPane().add(btnCopyToClipboard, gbc_btnCopyToClipboard);
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
