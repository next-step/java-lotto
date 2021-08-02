package calculator.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.model.Character;

class RegexComposerTest {

	@Test
	@DisplayName("문자열을 입력하는 패턴에 컬렉션에의하여 분리한다.")
	public void returnToArray() {
		String inputValue1 = "1,2,3";
		List<Character> result = RegexComposer.createCharacters(inputValue1);

		assertThat(result).extracting("character").containsExactly(1, 2, 3);

		String inputValue2 = "//,\n1,2,3";
		List<Character> result2 = RegexComposer.createCharacters(inputValue2);

		assertThat(result2).extracting("character").containsExactly(1, 2, 3);
	}

}