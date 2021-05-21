package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorModelTest {

	CalculatorModel sut;

	@ParameterizedTest
	@NullAndEmptySource
	void 빈문자열_또는_Null값을_입력할경우_0을_반환(String input) {
		sut = new CalculatorModel(input);
		assertThat(sut.execute()).isEqualTo(0);
	}

	@Test
	void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환() {
		sut = new CalculatorModel("1");
		assertThat(sut.execute()).isEqualTo(1);

		sut = new CalculatorModel("2");
		assertThat(sut.execute()).isEqualTo(2);

		sut = new CalculatorModel("999999999999");
		assertThat(sut.execute()).isEqualTo(999_999_999_999L);

		sut = new CalculatorModel("-1");
		assertThatThrownBy(() -> sut.execute())
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("유효하지 않은 입력입니다");
	}

	@Test
	void 숫자_두개를_컴마구분자로_입력할_경우_두숫자의_합을_반환한다() {

		sut = new CalculatorModel("0,1");
		assertThat(sut.execute()).isEqualTo(1);

		sut = new CalculatorModel("1,2");
		assertThat(sut.execute()).isEqualTo(3);

		sut = new CalculatorModel("999999999999,999999999999");
		assertThat(sut.execute()).isEqualTo(999999999999L * 2);

		sut = new CalculatorModel("-1,-1");
		assertThatThrownBy(() -> sut.execute())
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("유효하지 않은 입력입니다");
	}

	@Test
	void name() {
	}
}