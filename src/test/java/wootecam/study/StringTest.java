package wootecam.study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@Test
	@DisplayName("요구사항1 - 1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항1 - 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현")
	void splitOne() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항2 - (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현")
	void testSubString() {
		String target = "(1,2)";
		String result = target.substring(1, target.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}

	@ParameterizedTest
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	@DisplayName("요구사항3 - abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
	void testCharAt(int input, char expected) {
		String target = "abc";
		assertEquals(expected, target.charAt(input));
	}

	@Test
	@DisplayName("요구사항3 - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
	void testCharAtError() {
		assertThatThrownBy(() -> {
			String target = "abc";
			target.charAt(4);
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
