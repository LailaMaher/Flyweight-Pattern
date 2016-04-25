package flyweight.design.pattern;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import java.awt.GraphicsEnvironment;

public class Word extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final int WINDOW_WIDTH=1300, WINDOW_HEIGHT=700, NUMBER_OF_LETTERS=1000000;
	Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	Font[] fonts = {new Font("Serif", Font.ITALIC | Font.BOLD, 18), 
			new Font("Monospaced", Font.ITALIC , 16),
			new Font("SansSerif",Font.BOLD, 20)};
	
	public Word(){
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JButton button = new JButton("Generate Random Text");
		final JPanel panel = new JPanel();
		
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.SOUTH);
		
		setBounds(20, 20, WINDOW_WIDTH, WINDOW_HEIGHT); 
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				Graphics graphics = panel.getGraphics();
								
				long startTime = System.nanoTime();
								
				for(int i = 0; i < NUMBER_OF_LETTERS; ++i){
					Glyph glyph = GlyphFactory.getGlyph(getRandomChar(),
														getRandomFont());
					glyph.draw(graphics, getRandomX(), getRandomY());	
				}
				
				long endTime = System.nanoTime();
				long duration = (endTime - startTime)/1000000;
				System.out.println(duration + " milliseconds to get flyweight object\n\t\t and execute draw method");
				System.out.println(Letter.numberObjects + " letter objects are created");
			}
		});
	}
	
	private int getRandomX(){
		return (int)(Math.random()*WINDOW_WIDTH);
	}
	private int getRandomY(){
		return (int)(Math.random()*WINDOW_HEIGHT);
	}
	private Character getRandomChar(){
		return alphabet[(int)(Math.random()*alphabet.length)];
	}
	private Font getRandomFont(){
		return fonts[(int)(Math.random()*fonts.length)];
	}
	
}
