package lottomanual.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

	@ParameterizedTest(name = "로또 번호 크기 비교 {index} [{arguments}]")
	@CsvSource(value = {
			"1,2,-1",
			"2,1,1",
			"1,1,0",
	})
	@DisplayName("로또 번호 크기 비교")
	void lotto_number_compare(int firstNumber, int secondNumber, int compareTo) throws Exception {
		//given
		LottoNumber number1 = LottoNumber.valueOf(firstNumber);
		LottoNumber number2 = LottoNumber.valueOf(secondNumber);

		//when
		int compare = number1.compareTo(number2);

		//then
		assertThat(compare).isEqualTo(compareTo);

	}

	@Test
	@DisplayName("번호 동일 여부")
	void same_number() throws Exception {
		//given
		LottoNumber number1 = LottoNumber.valueOf(1);
		LottoNumber number2 = LottoNumber.valueOf(1);

		//when
		boolean equals = number1.equals(number2);

		//then
		assertThat(equals).isTrue();

	}

	@ParameterizedTest(name = "로또 번호 검증 정상 {index} [{arguments}]")
	@ValueSource(ints = {
			1,
			45
	})
	@DisplayName("로또 번호 검증 정상 범위")
	void validate_lotto_number(int number) throws Exception {
		//given


		//when
		LottoNumber lottoNumber = LottoNumber.valueOf(number);

		//then
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@ParameterizedTest(name = "로또 번호 검증 예외 {index} [{arguments}]")
	@ValueSource(ints = {
			0,
			46
	})
	@DisplayName("로또 번호 검증 정상 범위 초과")
	void validate_lotto_number_exception(int number) throws Exception {
		//given


		//when
		ThrowableAssert.ThrowingCallable lottoNumber = () -> LottoNumber.valueOf(number);

		//then
		assertThatThrownBy(lottoNumber).isInstanceOf(LottoNumberException.class)
		                               .hasMessage("로또 번호는 1~45 까지만 가능합니다.");
	}

	@Test
	@DisplayName("로또 번호 캐싱 검증")
	void validate_lotto_number_caches() throws Exception {
		//given
		LottoNumber lottoNumber1 = LottoNumber.valueOf(1);
		LottoNumber lottoNumber2 = LottoNumber.valueOf(1);

		//when
		boolean isEqual = lottoNumber1 == lottoNumber2;

		//then
		assertThat(isEqual).isTrue();
	}

}