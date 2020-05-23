package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import utils.ValidationUtils;

class ValidationUtilsTest {

	@Test
	public void checkNegativeValue_음수() {
		int targetValue = -3;
		assertThatThrownBy(() -> {
			assertThat(ValidationUtils.checkNegativeValue(targetValue)).isEqualTo(targetValue);
		}).isInstanceOf(RuntimeException.class)
		  .hasMessageContaining("음수가 입력되었습니다. [" + targetValue + "]");
	}

}
