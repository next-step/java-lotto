package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.service.InputParser;

public class InputParserTest {

	private InputParser inputParser;

	@BeforeEach
	public void setUp() {
		inputParser = new InputParser();
	}

	@DisplayName("올바른 형식이 아닌 숫자")
	@Test
	void nullCarNameInput() {
		String input = "숫 + 2";
		Class expect = IllegalArgumentException.class;
		String expectedMsg = "올바르지 않은 숫자 입력:";

		assertThatThrownBy(() -> 	inputParser.parseTokens(input))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);
	}


	@DisplayName("올바른 형식이 아닌 기호")
	@Test
	public void inputIllegalInputError() {
		String input = "1 ++ 2";
		Class expect = IllegalArgumentException.class;
		String expectedMsg = "올바르지 않은 기호 입력:";

		assertThatThrownBy(() -> inputParser.parseTokens(input))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);
	}

	@DisplayName("빈문자 입력값")
	@ParameterizedTest
	@NullAndEmptySource
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
		Class expect = IllegalArgumentException.class;
		String expectedMsg = "입력값이 null 이거나 비어있습니다.";

		assertThatThrownBy(() -> inputParser.parseTokens(input))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);
	}

}
