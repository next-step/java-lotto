package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void splitCase1() {
		assertThat("1,2".split(",")).containsExactly("1", "2");
	}

	@Test
	void splitCase2() {
		assertThat("1".split(",")).containsExactly("1");
	}

	@Test
	void substring() {
		assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
	}

	@DisplayName("문자열의 특정 위치 문자를 비교하는 테스트")
	@Test
	void charAt() {
		String str = "abc";
		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');
	}

	@DisplayName("문자열의 길이보다 큰 위치의 문자를 가져올 때 발생하는 예외 테스트")
	@Test
	void charAtWithStringIndexOutOfBoundsException() {
		assertThatThrownBy(() -> "abc".charAt(99)).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("9");
	}

}
