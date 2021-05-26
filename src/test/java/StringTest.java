import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

	@Test
	@DisplayName("String split method를 이용하여 문자열 자르기 테스트")
	void splitTest() {
		assertThat("1,2".split(","))
			.hasSize(2)
			.contains("1", "2");
	}

	@Test
	@DisplayName("String split method를 이용하여 하나의 문자만 가지는 문자열 자르기 테스트")
	void splitTestWithSingleText() {
		assertThat("1".split(","))
			.containsExactly("1");
	}

	@Test
	@DisplayName("String substring을 이용하여 첫번째 문자와 끝 문자 자르기 테스트")
	void substringTest() {
		String text = "(1,2)";
		assertThat(text.substring(1, text.length()-1))
			.isEqualTo("1,2");
	}

	@ParameterizedTest(name = "String charAt을 이용한 특정 위치 문자 얻기 테스트. index:{0}, expected:{1}")
	@CsvSource(value = {
		"0,a", "1,b", "2,c"
	})
	void charAtTest(final int index, final char expected) {
		assertThat("abc".charAt(index))
			.isEqualTo(expected);
	}

	@ParameterizedTest(name = "String charAt, 범위값을 넘어가는 특정 위치 참조 테스트. index:{0}")
	@ValueSource(ints = {
		-1, 3, 4, 5
	})
	void charAtTestWithStringIndexOutOfBoundsException(final int index) {
		assertThatThrownBy(()-> "abc".charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: " + index);
	}
}
