package calculator.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharactersTest {

	@Test
	@DisplayName("문자열입력시 정보를 저장후 그 값만 반환한다.")
	public void sumValues(){
		Character character1 = new Character(1);
		Character character2 = new Character(2);
		Character character3 = new Character(3);
		List<Character> initCharacters = new ArrayList<>();
		initCharacters.add(character1);
		initCharacters.add(character2);
		initCharacters.add(character3);

		Characters characters = new Characters(initCharacters);

		List<Character> result = characters.getCharacters();

		assertThat(result).extracting("character").containsExactly(1,2,3);
	}

}