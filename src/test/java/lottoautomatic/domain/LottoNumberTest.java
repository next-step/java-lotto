package lottoautomatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

	@ParameterizedTest(name = "로또 번호 크기 비교 {index} [{arguments}]")
	@CsvSource(value = {
			"1,2,-1",
			"2,1,1"
	})
	@DisplayName("로또 번호 크기 비교")
	void lotto_number_compare(int firstNumber, int secondNumber, int compareTo) throws Exception {
		//given
		LottoNumber number1 = new LottoNumber(firstNumber);
		LottoNumber number2 = new LottoNumber(secondNumber);

		//when
		int compare = number1.compareTo(number2);

		//then
		assertThat(compare).isEqualTo(compareTo);

	}

	@Test
	@DisplayName("번호 동일 여부")
	void same_number() throws Exception {
		//given
		LottoNumber number1 = new LottoNumber(1);
		LottoNumber number2 = new LottoNumber(1);

		//when
		boolean equals = number1.equals(number2);

		//then
		assertThat(equals).isTrue();

	}
}