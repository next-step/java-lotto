package step1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class ParserTest {

	private Parser parser;

	@BeforeEach
	void setup() {
		parser = new Parser();
	}

	@Test
	void 기본_구분자_콤마로_이루어진_문자열이_파싱된다() {
		// given
		String givenString = "1,2,3";
		List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);

		// when
		List<Integer> result = parser.parse(givenString);

		// then
		assertThat(result).isEqualTo(expectedNumbers);
	}

	@Test
	void 기본_구분자_콜론으로_이루어진_문자열이_파싱된다() {
		// given
		String givenString = "4:5:6";
		List<Integer> expectedNumbers = Arrays.asList(4, 5, 6);

		// when
		List<Integer> result = parser.parse(givenString);

		// then
		assertThat(result).isEqualTo(expectedNumbers);
	}

	@Test
	void 기본_구분자_콤마와_콜론으로_이루어진_문자열이_파싱된다() {
		// given
		String givenString = "1:2,3:4";
		List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4);

		// when
		List<Integer> result = parser.parse(givenString);

		// then
		assertThat(result).isEqualTo(expectedNumbers);
	}

	@Test
	void 음수가_들어가면_예외가_터진다() {
		// given
		String givenString = "1:-2,3:4";

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parser.parse(givenString);
		});
	}

	@Test
	void 숫자가_아닌_문자열이_들어가면_예외가_터진다() {
		// given
		String givenString = "1:2,abcd:4";

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parser.parse(givenString);
		});
	}

	@Test
	void 추가_구분자를_넣을_수_있다() {
		// given
		String givenString = "//;\n1;2,3";
		List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);

		// when
		List<Integer> result = parser.parse(givenString);

		// then
		assertThat(result).isEqualTo(expectedNumbers);
	}

	@Test
	void 빈_문자열이_입력되면_0이_들어있는_리스트가_반환된다() {
		// given
		String givenString = "";
		List<Integer> expectedNumbers = Collections.singletonList(0);

		// when
		List<Integer> result = parser.parse(givenString);

		// then
		assertThat(result).isEqualTo(expectedNumbers);
	}

	@Test
	void null이_입력되면_0이_들어있는_리스트가_반환된다() {
		// given
		String givenString = null;
		List<Integer> expectedNumbers = Collections.singletonList(0);

		// when
		List<Integer> result = parser.parse(givenString);

		// then
		assertThat(result).isEqualTo(expectedNumbers);
	}

}
