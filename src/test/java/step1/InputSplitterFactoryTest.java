package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.ColonInputSplitter;
import step1.domain.CommaColonInputSplitter;
import step1.domain.CommaInputSplitter;
import step1.domain.InputSplitter;
import step1.domain.InputSplitterFactory;

public class InputSplitterFactoryTest {

	@DisplayName("쉼표 구분자 문자열 입력시 팩토리가 쉼표 문자열 구분기 반환")
	@Test
	void given_comma_separated_numbers_then_factory_of_when_return_comma_input_splitter() {
		String input = "1,2,3";
		InputSplitter commaSplitter = InputSplitterFactory.of(input);
		assertThat(commaSplitter).isInstanceOf(CommaInputSplitter.class);
	}

	@DisplayName("콜론 구분자 문자열 입력시 팩토리가 콜론 문자열 구분기 반환")
	@Test
	void given_colon_separated_numbers_then_factory_of_when_return_colon_input_splitter() {
		String input = "1:2:3";
		InputSplitter colonSplitter = InputSplitterFactory.of(input);
		assertThat(colonSplitter).isInstanceOf(ColonInputSplitter.class);
	}

	@DisplayName("쉼표 또는 콜론 구분자 문자열 입력시 팩토리가 쉼표 또는 콜론 문자열 구분기 반환")
	@Test
	void given_comma_colon_separated_numbers_then_factory_of_when_return_comma_colon_input_splitter() {
		String input = "1,2:3";
		InputSplitter colonSplitter = InputSplitterFactory.of(input);
		assertThat(colonSplitter).isInstanceOf(CommaColonInputSplitter.class);
	}

}
