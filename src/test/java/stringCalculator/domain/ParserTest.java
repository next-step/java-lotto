package stringCalculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

	@DisplayName("문자열을 int 타입의 숫자로 바꿔 반환한다")
	@Test
	void convertToNum() {
		Parser parser = new Parser();
		assertThat(parser.parseNumber("3")).isEqualTo(3);
	}
}