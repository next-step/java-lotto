import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

	@Test
	@DisplayName("구분자를 찾아 분리하는 기능 테스트")
	void findSeparatorTest(){
		// given
		final String text = "//;\n1;2;3";

		// when
		SeparatedText separatedText = StringAddCalculator.findSeparator(text);

		// then
		assertThat(separatedText).as("구분자 분리에 실패했습니다.").isNotNull();
		assertThat(separatedText.getDelimiter()).isNotEmpty().isEqualTo(";");
		assertThat(separatedText.getTexts()).isNotEmpty().isEqualTo("1;2;3");
	}

	@ParameterizedTest(name = "구분자 분리가 불가능한 케이스 테스트, text={0}")
	@ValueSource(strings = {
		"", "//\n1;2;3", "//1;2;3", "\n1;2;3", "1;2;3"
	})
	void findSeparatorTestWithInvalidText(final String text){
		assertThat(StringAddCalculator.findSeparator(text))
			.isNull();
	}

	@Test
	@DisplayName("구분자 분리 동작시 입력값이 null일때 케이스 테스트")
	void findSeparatorTestWithNull(){
		assertThat(StringAddCalculator.findSeparator(null))
			.isNull();
	}

	@ParameterizedTest(name = "입력받은 구분자를 기준으로 문자열 split 테스트. delimter={0}, text={1}")
	@CsvSource(value = {
		";$1;2;3", "@$1@2@3", ",$1,2,3"
	}, delimiter = '$')
	void splitTest(final String delimiter, final String text){
		assertThat(StringAddCalculator.split(delimiter, text))
			.containsExactly("1", "2", "3");
	}

	@ParameterizedTest(name = "split이 불가능한 테스트 케이스. delimiter={0}, text={1}")
	@CsvSource(value = {
		"$", "$1;2;3", ";$"
	}, delimiter = '$')
	void splitTestFailedTest(final String delimiter, final String text){
		assertThat(StringAddCalculator.split(delimiter, text))
			.isNull();
	}
}
