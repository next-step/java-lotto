package calculator.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharactersTest {

	@Test
	@DisplayName("문자열의 집합들에 대하여 합산을 반환한다.")
	public void sumValues(){
		Character character1 = new Character(1);
		Character character2 = new Character(2);
		Character character3 = new Character(3);

		Characters characters = new Characters(character1,character2,character3);

		int result = characters.sumCharacters();

		assertThat(result).isEqualTo(6);
	}

}