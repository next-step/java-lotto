package stringaddition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionCalculatorTest {

	@Test
	@DisplayName("구분자로 문자열을 분리 후 각 숫자의 합을 반환")
	void split() throws Exception {
		//given
		String formula = "1,2:3";
		AdditionCalculator additionCalculator = new AdditionCalculator();

		//when
		int solution = additionCalculator.sum(formula);

		//then
		assertThat(solution).isEqualTo(6);
	}
	
}
