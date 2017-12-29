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
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * 
 * @author Jonathan
 *
 */
public class main_w extends JFrame{
	private JTextField txtDragAlbumArt;
	private AudioFile audioFile;
	private Tag tag;
	private Vector<String> vlist;
	public main_w(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		
		txtDragAlbumArt = new JTextField();
		txtDragAlbumArt.setHorizontalAlignment(SwingConstants.CENTER);
		txtDragAlbumArt.setText("DRAG ALBUM ART HERE");
		txtDragAlbumArt.setEditable(false);
		GridBagConstraints gbc_txtDragAlbumArt = new GridBagConstraints();
		gbc_txtDragAlbumArt.insets = new Insets(0, 0, 5, 0);
		gbc_txtDragAlbumArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDragAlbumArt.gridx = 1;
		gbc_txtDragAlbumArt.gridy = 2;
		getContentPane().add(txtDragAlbumArt, gbc_txtDragAlbumArt);
		txtDragAlbumArt.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		getContentPane().add(textArea, gbc_textArea);
		
		vlist = new Vector<String>();
		new FileDrop( textArea, new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    {   textArea.append( files[i].getCanonicalPath() + "\n" );
                    	vlist.addElement(files[i].getCanonicalPath());
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
		
		new FileDrop( txtDragAlbumArt, new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {  
        	for( int i = 0; i < vlist.size(); i++ )
        	{
        	 try {
					audioFile = AudioFileIO.read(new File(vlist.get(i)));
					tag = audioFile.getTag();
					Artwork cover = ArtworkFactory.createArtworkFromFile(new File(files[0].getCanonicalPath()));
	                tag.deleteArtworkField();
	                tag.setField(cover);
	                audioFile.commit();
				} catch (CannotReadException e) {
					System.out.println("CannotReadException");
				} catch (IOException e) {
					System.out.println("IOException");							
				} catch (TagException e) {
					System.out.println("TagException");	
				} catch (ReadOnlyFileException e) {
					System.out.println("ReadOnlyFileException");	
				} catch (InvalidAudioFrameException e) {
					System.out.println("InvalidAudioFrameException");	
				} catch (CannotWriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	}
            }   // end filesDropped
        }); // end FileDrop.Listener
		
		JButton btnNewButton = new JButton("CLEAR ALL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				vlist.removeAllElements();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("COPY TO CLIPBOARD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		
	}
	public static void main(String[] args) {
		main_w window = new main_w();
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setSize(800, 700);
		//window.pack();
		window.setTitle("Easy Folder Name'er");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
