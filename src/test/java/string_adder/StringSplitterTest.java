package string_adder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class StringSplitterTest {

	@Test
	void splitBySeparator_기본구분자() {
		// given
		String text = "1:2,3";

		// when then
		assertThat(StringSplitter.splitBySeparator(text, "//(.*)\n(.*)", ":|,"))
				.containsExactly("1","2","3");
	}


	@Test
	void splitBySeparator_커스텀구분자() {
		// given
		String text = "//ab\n5ab10";

		// when then
		assertThat(StringSplitter.splitBySeparator(text, "//(.*)\n(.*)", ":|,"))
				.containsExactly("5", "10");
	}
}