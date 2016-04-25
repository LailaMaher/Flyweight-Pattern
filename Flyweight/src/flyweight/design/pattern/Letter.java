package flyweight.design.pattern;

import java.awt.Font;
import java.awt.Graphics;

public class Letter implements Glyph {
	
	/*
	 *  Intrinsic state is stored in the flyweight  
	 *  it consists of information that’s independent of the flyweight’s context, 
	 *  thereby making it sharable. 
	 *  Usually Immutable (unchanged)
	 */
	
	final private Character character;
	final private Font font;
	public static int numberObjects = 0;
	
	public Letter(Character character, Font font){
		numberObjects++;
		this.character = character;
		this.font = font;
	}
	
	/* 
	 * The extrinsic state depends on and varies with the flyweight’s context 
	 * and therefore can’t be shared. 
	 * Client objects are responsible for passing extrinsic state 
	 * to the flyweight when it needs it.
	 */
	
	@Override
	public void draw(Graphics graphics, int row, int column) {
		graphics.setFont(font);
		graphics.drawString(String.valueOf(character), row, column);
	}

}
