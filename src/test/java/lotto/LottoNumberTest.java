package lotto;

import exception.LottoException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static type.LottoExceptionType.WRONG_LOTTO_NUMBER;

class LottoNumberTest {

	@ParameterizedTest(name = "로또 숫자 범위를 넘어가는 유효값 테스트. number[{0}]")
	@ValueSource(ints = {
		0, 46, -1
	})
	void validTest(final int number) {
		assertThatThrownBy(()->new LottoNumber(number))
			.isInstanceOf(LottoException.class)
			.hasMessageContaining(WRONG_LOTTO_NUMBER.message());
	}

	@ParameterizedTest(name = "객체 비교 테스트. sourceNumber[{0}], targetNumber[{1}], expected[{2}]")
	@CsvSource(value = {
		"1,1,true", "1,2,false"
	})
	void equalsTest(final int sourceNumber, final int targetNumber, final boolean expected) {
		// given
		LottoNumber source = new LottoNumber(sourceNumber);
		LottoNumber target = new LottoNumber(targetNumber);

		assertThat(source.equals(target))
			.isEqualTo(expected);
	}



	@ParameterizedTest(name = "CompareTo 테스트, source[{0}], target[{1}], expected[{2}]")
	@CsvSource(value = {
		"1, 2, -1", "2, 1, 1", "2, 2, 0"
	})
	void compareToTest(final int sourceNumber, final int targetNumber, final int expected) {
		// given
		LottoNumber source = new LottoNumber(sourceNumber);
		LottoNumber target = new LottoNumber(targetNumber);

		// when
		assertThat(source.compareTo(target))
			.isEqualTo(expected); // then
	}
}
