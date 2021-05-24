package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ExceptionMessage;

class NumberTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 0})
	public void 숫자하나를_문자열로_입력할_경우_해당숫자를_반환한다(int number){
		Number singleNumbrt = new Number(number);

		assertThat(number).isEqualTo(singleNumbrt.number());
		assertThat(new Number(number)).isEqualTo(singleNumbrt);
	}
}