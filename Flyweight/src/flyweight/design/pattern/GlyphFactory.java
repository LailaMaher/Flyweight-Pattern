package flyweight.design.pattern;

import java.awt.Font;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class GlyphFactory {

	private static Table<Character, Font, Glyph> 
						glyphs = HashBasedTable.create();
	
	public static Glyph getGlyph(Character character, Font font){
		Glyph glyph = glyphs.get(character, font);
		if(glyph == null){
			glyph = new Letter(character, font);
			glyphs.put(character, font, glyph);
		}
		return glyph;
	}
}
