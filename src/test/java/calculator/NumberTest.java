package calculator;

import calculator.domain.Number;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {
	@Test
	void 입력한_숫자_값을_가진다() {
		assertThat(new Number("3").getNumber()).isEqualTo(3);
	}

	@Test
	void 숫자가_아니면_예외_호출() {
		assertThatExceptionOfType(NumberFormatException.class)
				.isThrownBy(() -> new Number("b"))
				.withMessageMatching("숫자를 입력해야 합니다.");
	}
}
