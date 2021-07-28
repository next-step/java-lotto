package stringaddition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionCalculatorTest {

	@ParameterizedTest(name = "문자열을 분리 후 각 숫자의 합을 반환 {index} [{arguments}]")
	@ValueSource(strings = {
			"1,2:3",
			"1,2,3",
			"1:2:3",
			"//-\n1-2-3",
			"//;\n1;2;3",
			"///\n1/2/3",
	})
	@DisplayName("지정 구분자 또는 기본 구분자로 문자열을 분리 후 각 숫자의 합을 반환")
	void split(String formula) throws Exception {
		//given
		AdditionCalculator additionCalculator = new AdditionCalculator();

		//when
		int solution = additionCalculator.sum(formula);

		//then
		assertThat(solution).isEqualTo(6);
	}
	
}
