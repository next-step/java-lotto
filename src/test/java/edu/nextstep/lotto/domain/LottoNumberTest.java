package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoNumber: 로또 번호 각각의 원시값을 포장한 클래스")
class LottoNumberTest {
	@DisplayName("생성자: LottoNumber 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		LottoNumber lottoNumber = new LottoNumber(1);
		assertThat(lottoNumber)
			.isNotNull()
			.isInstanceOf(LottoNumber.class)
			.hasFieldOrPropertyWithValue("lottoNumber", 1);
	}
}