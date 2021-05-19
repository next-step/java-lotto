package kht2199;

import static org.assertj.core.api.Assertions.*;

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
}
