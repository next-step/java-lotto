package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@DisplayName("로또의 번호가 1부터 45까지의 숫자를 만족하는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 46, -1})
	void 로또번호가_1부터_45까지의_숫자를_만족하는지_테스트(int number) {
		assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void compareTo_test() {
		LottoNumber smallNumber = new LottoNumber(10);
		LottoNumber sameNumber = new LottoNumber(10);
		LottoNumber bigNumber = new LottoNumber(11);

		assertThat(smallNumber.compareTo(bigNumber)).isEqualTo(-1);
		assertThat(smallNumber.compareTo(sameNumber)).isEqualTo(0);
		assertThat(bigNumber.compareTo(smallNumber)).isEqualTo(1);
	}
}
