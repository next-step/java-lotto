package kht2199;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Spec
 *
 * 1. "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
 * 2. "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
 */
public class StringTest {

	@Test
	void splitTest() {
		assertThat("1,2".split(","))
			.containsExactly("1", "2");
	}

	@Test
	void splitForLengthOneStringTest() {
		assertThat("1".split(","))
			.containsExactly("1");
	}
}
