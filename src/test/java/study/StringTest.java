package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("String 학습 테스트")
public class StringTest {

	@DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다")
	@Test
	void splitComma() {
		String targetString = "1,2";

		String[] result = targetString.split(",");

		assertThat(result).containsExactly("1", "2");
	}

	@DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환한다")
	@Test
	void splitCommaOnlyOne() {
		String targetString = "1";

		String[] result = targetString.split(",");

		assertThat(result).containsExactly("1");
	}

	@DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다")
	@Test
	void subString() {
		String targetString = "(1,2)";

		String result = targetString.substring(1, targetString.length() - 1);

		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
	@ParameterizedTest
	@CsvSource({ "0,a", "1,b", "2,c" })
	void charAt(int index, char expected) {
		String targetString = "abc";

		assertEquals(targetString.charAt(index), expected);
	}

	@DisplayName("String의 charAt의 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
	@Test
	void charAtOutOfIndex() {
		String targetString = "abc";

		assertThatThrownBy(() -> targetString.charAt(targetString.length() + 1))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
