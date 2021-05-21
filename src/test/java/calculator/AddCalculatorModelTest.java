package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class AddCalculatorModelTest {

	AddCalculatorModel sut;

	@ParameterizedTest(name = "빈 문자열 또는 Null 테스트")
	@NullAndEmptySource
	void 빈문자열_또는_Null_값을_입력할경우_0을_반환(String userInput) {
		sut = new AddCalculatorModel(userInput);
		assertThat(sut.execute()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "999999999999"})
	void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환(String value) {
		long expected = Long.parseLong(value);
		sut = new AddCalculatorModel(value);
		assertThat(sut.execute()).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "-1,-1", "-1,2:3"})
	void 마이너스_또는_유효하지_않는_값_입력시_예외호출(String value) {
		sut = new AddCalculatorModel(value);
		assertThatThrownBy(() -> sut.execute())
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,1:1", "1,2:3", "999999999999,999999999999:1999999999998"}, delimiterString = ":")
	void 숫자_두개를_컴마구분자로_입력할_경우_두숫자의_합을_반환한다(String userInput, Long expected) {
		sut = new AddCalculatorModel(userInput);
		assertThat(sut.execute()).isEqualTo(expected);
	}

	@ParameterizedTest(name = "구분자를_컴마_뿐만_아니라_콜론도_가능")
	@ValueSource(strings = {"1,2:3","1:2:3"})
	void 구분자를_컴마_뿐만_아니라_콜론도_가능(String value) {
		sut = new AddCalculatorModel(value);
		assertThat(sut.execute()).isEqualTo(6);
	}

	@ParameterizedTest(name = "[{index}]({argumentsWithNames})“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정하면 지정된 커스텀 구분자로 구분된다.")
	@ValueSource(strings = {"//;\n1;2;3","//a\n1a2a3", "//!\n1!2!3"})
	void _1(String value) {
		sut = new AddCalculatorModel(value);
		assertThat(sut.execute()).isEqualTo(6);
	}

	@ParameterizedTest(name = "[{index}] 유효하지 않는 커스텀 구분자({argumentsWithNames})를 지정하면 예외 호출한다.")
	@ValueSource(strings = {"//abc\n1abc2abc3", "//;\n1;2:3", "//!\n1!2,3"})
	void _2(String value) {
		sut = new AddCalculatorModel(value);
		assertThatThrownBy(() -> sut.execute()).isInstanceOf(RuntimeException.class);
	}
}