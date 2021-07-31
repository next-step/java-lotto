package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharacterTest {

	@Test
	@DisplayName("음수값을 생성하면 예외가 발생된다.")
	public void createPositiveCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			new Character(-1)
		);
	}

	@Test
	@DisplayName("입력된 숫자 문자열을 반환한다.")
	public void createCharacterReturnValue() {
		Character character1 = new Character(1);
		Character character2 = new Character(3);
		Character character3 = new Character(5);

		assertThat(character1.getCharacter()).isEqualTo(1);
		assertThat(character2.getCharacter()).isEqualTo(3);
		assertThat(character3.getCharacter()).isEqualTo(5);

		Character character4 = new Character(1);
		Character character5 = new Character(3);
		Character character6 = new Character(5);

		assertThat(character1).isEqualTo(character4);
		assertThat(character2).isEqualTo(character5);
		assertThat(character3).isEqualTo(character6);
	}
}
