package study;

import static org.assertj.core.api.Assertions.*;

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
		assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
	}

}
