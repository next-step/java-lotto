package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ExceptionMessage;

class NumberTest {


	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "0"})
	public void 숫자하나를_문자열로_입력할_경우_해당숫자를_반환한다(String number){
		Number singleNumbrt = new Number(number);

		assertThat(Integer.valueOf(number)).isEqualTo(singleNumbrt.number());
		assertThat(new Number(number)).isEqualTo(singleNumbrt);
	}


	@ParameterizedTest
	@ValueSource(strings = {"-1", "-2", "-3"})
	public void 음수를_전달할경우_RuntimeException예외가_발생해야한다(String number){
		assertThatThrownBy(() -> new Number(number))
				.isInstanceOf(NumberFormatException.class)
				.hasMessage(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
	}
}