package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("charAt()_예외발생_테스트")
	void charAt_test() {
		String abc = "abc";
		assertThat(abc.charAt(0)).isEqualTo('a');
		assertThat(abc.charAt(1)).isEqualTo('b');
		assertThat(abc.charAt(2)).isEqualTo('c');

		assertThatThrownBy(() -> {
			char result = abc.charAt(4);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range:");

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
			char result = abc.charAt(5);
		}).withMessageMatching("String index out of range: 5");
	}

	@Test
	@DisplayName("substring()_메서드_테스트")
	void substring_test() {
		String str = "(1,2)";
		String result = str.substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("split()_메서드_테스트")
	void split_test() {
		String str = "1,2";
		String[] result = str.split(",");
		assertThat(result).contains("2", "1");
		assertThat(result).containsExactly("1", "2");
	}
}
