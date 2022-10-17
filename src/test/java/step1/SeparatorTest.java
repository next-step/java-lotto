package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SeparatorTest {
	@Test
	@DisplayName("식 받아서 숫자 분리")
	void separateNumbers() {
		Separator separator = new Separator("1 + 2 + 3");
		assertThat(separator.getTerms()).isEqualTo(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("식 받아서 기호 분리")
	void separateSigns() {
		Separator separator = new Separator("1 + 2 + 3");
		assertThat(separator.getSigns()).isEqualTo(Arrays.asList("+", "+"));
	}

	@ParameterizedTest
	@DisplayName("식 받아서 숫자 예외")
	@ValueSource(strings = {"a + 2 + 3", "-a + 2 + 3", "1 + : + 3"})
	void separateValidateNumber(String input) {
		assertThatThrownBy(() -> new Separator(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자만 계산할 수 있습니다");
	}
}
