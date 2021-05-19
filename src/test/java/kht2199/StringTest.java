package kht2199;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	/**
	 * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	 */
	@Test
	void splitTest() {
		assertThat("1,2".split(","))
			.containsExactly("1", "2");
	}

	/**
	 * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	 */
	@Test
	void splitForLengthOneStringTest() {
		assertThat("1".split(","))
			.containsExactly("1");
	}

	/**
	 * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
	 */
	@Test
	void removeBracketsUsingRegex() {
		assertThat("(1,2)".replaceAll("[()]", ""))
			.isEqualTo("1,2");
	}

	/**
	 * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
	 * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
	 * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
	 */
	@Test
	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
	void expectIndexOutOfBoundsExceptionWhenOverIndexSizeOfStringCharAt() {
		assertThatThrownBy(() -> "abc".charAt(3))
			.isInstanceOf(IndexOutOfBoundsException.class);
	}
}
