package stringaddition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NationalNumberTest {

	NationalNumber nationalNumber;

	@BeforeEach
	void setUp() {
		nationalNumber = new NationalNumber();
	}

	@ParameterizedTest(name = "음수 포함 여부 {index} [{arguments}]")
	@ValueSource(strings = {
			"-1",
			"-100"
	})
	@DisplayName("음수를 포함한 문자열을 입력한 경우 RuntimeException")
	void negative_text(String text) throws Exception {
		//given

		//when, then
		assertThatThrownBy(() -> nationalNumber.isValid(text)).isInstanceOf(NationalNumberException.class)
		                                              .hasMessage("음수를 포함한 문자열은 계산할 수 없습니다.");

	}

	@ParameterizedTest(name = "숫자가 아닌 문자 포함 여부 {index} [{arguments}]")
	@ValueSource(strings = {
			"일",
			"A",
			"!"
	})
	@DisplayName("숫자가 아닌 문자를 포함한 문자열을 입력한 경우 RuntimeException")
	void wrong_text(String text) throws Exception {
		//given

		//when, then
		assertThatThrownBy(() -> nationalNumber.isValid(text)).isInstanceOf(NationalNumberException.class)
		                                              .hasMessage("숫자가 아닌 문자를 포함하는 문자열은 계산할 수 없습니다.");

	}

}
