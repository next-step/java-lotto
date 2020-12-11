import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParsedNumberTest {
	@Test
	@DisplayName("기본 생성 시, ParsedNumber의 number는 0 이어야 한다.")
	void defaultParsedNumberTest() {
		ParsedNumber number = new ParsedNumber();
		assertThat(number).isEqualTo(new ParsedNumber("0"));
	}

	@Test
	@DisplayName("숫자 String 으로 생성 시, ParsedNumber의 number는 해당 숫자 이어야 한다.")
	void stringParsedNumberTest() {
		ParsedNumber number = new ParsedNumber("3");
		assertThat(number).isEqualTo(new ParsedNumber("3"));
	}

	@Test
	@DisplayName("음수 String 으로 생성 시, RuntimeException 예외가 발생해야 한다.")
	void throwExceptionForNegativeNumberTest() {
		assertThatThrownBy(() -> new ParsedNumber("-3")).isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("숫자가 아닌 String 으로 생성 시, RuntimeException 예외가 발생해야 한다.")
	void throwExceptionForNotNumberTest() {
		assertThatThrownBy(() -> new ParsedNumber("a")).isInstanceOf(RuntimeException.class);
	}
}
