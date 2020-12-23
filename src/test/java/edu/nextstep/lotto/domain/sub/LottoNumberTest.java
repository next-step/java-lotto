package edu.nextstep.lotto.domain.sub;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoNumber: 로또 번호 각각의 원시값을 포장한 클래스")
class LottoNumberTest {
	@DisplayName("생성자: LottoNumber 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		LottoNumber lottoNumber = LottoNumber.of(1);
		assertThat(lottoNumber)
			.isNotNull()
			.isInstanceOf(LottoNumber.class)
			.hasFieldOrPropertyWithValue("lottoNumber", 1);
	}

	@DisplayName("생성자: 범위 외의 로또 번호가 들어오면 Exception 발생.")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	public void generate_shouldException(int number) {
		assertThatThrownBy(() -> LottoNumber.of(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("isValid: LottoNumber 객체를 생성하기에 올바른 숫자면 true를 리턴함")
	@ParameterizedTest
	@CsvSource(value = {"-1,false", "0,false", "46,false", "1,true", "45,true"})
	void isValid(int number, boolean expected) {
		assertThat(LottoNumber.isValid(number)).isEqualTo(expected);
	}

	@DisplayName("equals: LottoNumber 객체의 원시값이 같으면 같은 LottoNumber 객체임.")
	@Test
	void equals() {
		assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
	}
}