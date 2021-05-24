package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
		27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45})
	@DisplayName("로또 번호 생성 테스트")
	public void createNumberTest(int number) {
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
		27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45})
	@DisplayName("로또 번호 비교 테스트")
	public void equalsNumberTest(int number) {
		LottoNumber sourceLottoNumber = new LottoNumber(number);
		LottoNumber expectedLottoNumber = new LottoNumber(number);
		assertThat(sourceLottoNumber.equals(expectedLottoNumber)).isEqualTo(true);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:false", "2:true", "3:false", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("로또 번호 같지 않는 경우 테스트")
	public void notEqualsNumberTest(int sourceNumber, boolean expectResult) {
		LottoNumber sourceLottoNumber = new LottoNumber(sourceNumber);
		LottoNumber expectedLottoNumber = new LottoNumber(2);
		assertThat(sourceLottoNumber.equals(expectedLottoNumber)).isEqualTo(expectResult);
	}

	@Test
	@DisplayName("로또 번호 잘못된 번호 입력시 에러 발생 테스트")
	public void createNumberException() {
		assertThatThrownBy(() -> new LottoNumber(46))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
