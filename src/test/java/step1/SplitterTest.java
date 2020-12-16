package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.InputSplitter;
import step1.domain.InputSplitterFactory;

public class SplitterTest {

	@DisplayName("쉼표로 구분된 문자열을 split() 하면 0 이상의 정수 Array 반환")
	@Test
	void given_comma_separated_numbers_when_splitter_split_then_return_number_array() {
		final String input = "1,2,3";
		InputSplitter commaSplitter = InputSplitterFactory.of(input);
		int[] result = commaSplitter.split(input);

		assertThat(result).containsSequence(1,2,3);
	}

	@DisplayName("콜론으로 구분된 문자열을 split() 하면 0 이상의 정수 Array 반환")
	@Test
	void given_colon_separated_numbers_when_splitter_split_then_return_number_array() {
		final String input = "1:2:3";
		InputSplitter colonSplitter = InputSplitterFactory.of(input);
		int[] result = colonSplitter.split(input);

		assertThat(result).containsSequence(1,2,3);
	}

	@DisplayName("쉼표 또는 콜론 으로 구분된 문자열을 split() 하면 0 이상의 정수 Array 반환")
	@Test
	void given_comma_or_colon_separated_numbers_when_splitter_split_then_return_number_array() {
		final String input = "1,2:3";
		InputSplitter commaColonSplitter = InputSplitterFactory.of(input);
		int[] result = commaColonSplitter.split(input);

		assertThat(result).containsSequence(1,2,3);
	}

}
