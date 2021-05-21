package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatedTextTest {

	@Test
	@DisplayName("구분자를 찾아 분리하는 기능 테스트")
	void findSeparatorTest(){
		// given
		final String text = "//;\n1;2;3";

		// when
		SeparatedText separatedText = SeparatedText.findSeparator(text);

		// then
		assertThat(separatedText).as("구분자 분리에 실패했습니다.").isNotNull();
		assertThat(separatedText.getDelimiter()).isNotEmpty().isEqualTo(",|:|;");
		assertThat(separatedText.getTexts()).isNotEmpty().isEqualTo("1;2;3");
	}
}
