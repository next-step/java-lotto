package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	@DisplayName("로또 번호 생성시 유효성검사 실패")
	void constructor_validate_fail(int number) {
		assertThatThrownBy(() -> new LottoNumber(number))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("range must in");
	}

	@ParameterizedTest
	@DisplayName("equals 테스트, 내부의 숫자의 equals 을 사용한다.")
	@CsvSource(value = {"1,1,true", "1,45,false"})
	void equalsTest(int number1, int number2, boolean expected) {
		// given
		LottoNumber lottoNumber1 = new LottoNumber(number1);
		LottoNumber lottoNumber2 = new LottoNumber(number2);

		// when & then
		assertThat(lottoNumber1.equals(lottoNumber2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("toString 테스트")
	@CsvSource(value = {"1,1", "45,45"})
	void toStringTest(int number, String toStringExpected) {
		assertThat(new LottoNumber(number).toString()).isEqualTo(toStringExpected);
	}

	@ParameterizedTest
	@DisplayName("LottoNumber 의 comparable 인터페이스 구현을 테스트한다. Integer.compare 와 결과가 같다.")
	@CsvSource(value = {"1,2,-1", "2,1,1", "1,1,0"})
	void compareToTest(int number1, int number2, int compareExpected) {
		LottoNumber lottoNumber1 = new LottoNumber(number1);
		LottoNumber lottoNumber2 = new LottoNumber(number2);

		// when & then
		assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(compareExpected);
	}
}