package flyweight.design.pattern;

import java.awt.Graphics;

public interface Glyph {
	public void draw(Graphics graphics, 
			int row, int column);	
}
