import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

	@Test
	@DisplayName("구분자를 찾아 분리하는 기능 테스트")
	void findSeperatorTest(){
		// given
		final String text = "//;\n1;2;3";

		// when
		SperatedText speratedText = StringAddCalculator.findSeperator(text);

		// then
		assertThat(speratedText).as("구분자 분리에 실패했습니다.").isNotNull();
		assertThat(speratedText.getSperator()).isNotEmpty().isEqualTo(";");
		assertThat(speratedText.getTexts()).isNotEmpty().isEqualTo("1;2;3");
	}

	@ParameterizedTest(name = "구분자 분리가 불가능한 케이스 테스트, text={0}")
	@ValueSource(strings = {
		"", "//\n1;2;3", "//1;2;3", "\n1;2;3", "1;2;3"
	})
	void findSeperatorTestWithInvalidText(final String text){
		assertThat(StringAddCalculator.findSeperator(text))
			.isNull();
	}

	@Test
	@DisplayName("구분자 분리 동작시 입력값이 null일때 케이스 테스트")
	void findSeperatorTestWithNull(){
		assertThat(StringAddCalculator.findSeperator(null))
			.isNull();
	}
}
