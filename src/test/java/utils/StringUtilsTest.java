package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import utils.ValidationUtils;

class StringUtilsTest {

	@Test
	public void parseInt() {
		assertThat(StringUtils.parseInt("3")).isEqualTo(3);
	}
}
