package calculator.model;

import java.util.Collections;
import java.util.List;

public class Characters {

	private final List<Character> characters;

	public Characters(List<Character> characters) {
		this.characters = characters;
	}

	public List<Character> getCharacters() {
		return Collections.unmodifiableList(characters);
	}
}
