package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	@DisplayName("문자열 숫자 변환 테스트")
	public void parseInt() {
		assertThat(StringUtils.parseInt("3")).isEqualTo(3);
	}
}
