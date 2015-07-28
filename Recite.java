import java.io.*; 
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Recite extends JFrame implements ActionListener{
    JLabel lblWord = new JLabel("word\t");
    JLabel lblMeaning = new JLabel("meaning");
    //JButton button_fast, button_slow, button_rest;
    JButton button_fast = new JButton("fast speed X4");
    JButton button_slow = new JButton("slow speed X0.5");
    JButton button_reset = new JButton("Reset");
    JButton button_new = new JButton("Add New Word");
    Timer timer;
    int cite_delay = 1000;

	public void init() {
        setSize( 400,300 );
        setTitle("College Grade 4 Words List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        // add background image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("free-simple-backgrounds.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        setContentPane(new JLabel(imageIcon));
        
        // add label and buttons
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(lblWord, c);
		getContentPane().add(lblMeaning, c);
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 0;       //aligned with lable
        c.gridwidth = 2;   //2 columns wide
        getContentPane().add(button_fast, c);
        c.insets = new Insets(0,0,0,0);
        getContentPane().add(button_slow, c);
        getContentPane().add(button_reset, c);
        getContentPane().add(button_new, c);
        
        // button action listener
        button_fast.addActionListener(new ButtonFastActionListener());
        button_slow.addActionListener(new ButtonSlowActionListener());
        button_reset.addActionListener(new ButtonResetActionListener());
        
        // add new word;
        button_new.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog add_words = new JDialog();
                add_words.setTitle("Dialog Created to Add New Words in Vocabulary List.");
                add_words.setSize(new Dimension(400, 100));
                add_words.setModal(true);
                // text input
                JTextField word = new JTextField(10);
                JTextField meanings = new JTextField(10);
                word.setEditable(true);
                meanings.setEditable(true);
                JLabel word_label = new JLabel("word");
                add_words.getContentPane().add(word_label);
                add_words.getContentPane().add(word);
                JLabel meanings_label = new JLabel("meaning");
                add_words.getContentPane().add(meanings_label);
                add_words.getContentPane().add(meanings);
                // text output to file
                JButton done = new JButton("Done");
                add_words.getContentPane().add(done);
                done.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent f) {
                        String word_new = word.getText();
                        String meanings_new = meanings.getText();
                        try {
                            writeAll(word_new, meanings_new);
                        }catch(IOException ex){}
                    }
                });
                // set panel
                add_words.setLayout(new FlowLayout());
                add_words.setVisible(true);
            }
            
            
        });
        
        
        // start reading
        try{
            readAll();
        }catch(IOException ex){}
        
        //Set up timer to drive cite events
        int pause =  1000;
        timer = new Timer(cite_delay, this);
        timer.setInitialDelay(pause);
        timer.start();
        
        // set frame
        setVisible(true);
	}
    
    // button action performed
    private class ButtonFastActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.setDelay(250);
        }
    }
    private class ButtonSlowActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.setDelay(2000);
        }
    }
    private class ButtonResetActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.setDelay(1000);
        }
    }
    
    // read in text to frame with various speed
    List<String> words = new ArrayList<>();
    List<String> meanings = new ArrayList<>();
    int current = 0;
    public void actionPerformed(ActionEvent f) {
        lblWord.setText( words.get(current)+"\t" );
        lblMeaning.setText( meanings.get(current) );
        current++;
    }
    
    // read from the text
	public void readAll( ) throws IOException{
		String fileName = "College_Grade4.txt";
		String charset = "GB2312";
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(fileName), charset)); 
		String line; 
		while ((line = reader.readLine()) != null) { 
			line = line.trim();
			if( line.length() == 0 ) continue;
			String[] parts = line.split("\t");
			words.add( parts[0]);
			meanings.add( parts[1]);
		} 
		reader.close();
	}

    // write out file
    public void writeAll(String word_new, String meanings_new ) throws IOException{
		String fileName = "College_Grade4.txt";
		String charset = "GB2312";
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(fileName, true));
        writer.write("\t"+word_new+"\t"+meanings_new);
        writer.flush();
		writer.close();
	}
    
    // main
	public static void main( String[] args){
		Recite f = new Recite();
        f.init();
	}

    
} 
