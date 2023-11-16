package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitTest {

	@Test
	void split() {
		String str = "1 + 2  * 3";

		String[] strings = str.split(" ");

		assertThat(strings).containsExactly("1", "+", "2", "", "*", "3");
	}
}
