package ordinary.object.instantiation;

import java.awt.Font;
import java.awt.Graphics;

public class Letter implements Glyph {
	
	private Character character;
	private Font font;
	private int row, column;
	
	public static int numberObjects = 0;
	
	public Letter(Character character, Font font, int row, int column){
		numberObjects++;
		this.character = character;
		this.font = font;
		this.row = row;
		this.column = column;
	}
	
	@Override
	public void draw(Graphics graphics) {
		graphics.setFont(font);
		graphics.drawString(String.valueOf(character), row, column);
	}

}
