package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationUtilsTest {

	@Test
	@DisplayName("음수가 입력된 경우, RuntimException")
	public void checkNegativeValue_음수() {
		int targetValue = -3;
		assertThatThrownBy(() -> {
			assertThat(ValidationUtils.checkNegativeValue(targetValue)).isEqualTo(targetValue);
		}).isInstanceOf(RuntimeException.class)
		  .hasMessageContaining("음수가 입력되었습니다. [" + targetValue + "]");
	}
	
	@Test
	@DisplayName("빈값 체크")
    @ParameterizedTest
    @CsvSource({"'1',false", "'',true"})
	public void checkEmpty(String inputValue, boolean expectedValue) {
		assertThat(ValidationUtils.checkEmpty(inputValue)).isEqualTo(expectedValue);
	}
}
