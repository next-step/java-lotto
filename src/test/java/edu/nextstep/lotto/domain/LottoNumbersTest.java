package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoNumbers: LottoNumber 목록의 일급 콜렉션 클래스")
class LottoNumbersTest {
	@DisplayName("생성자: LottoNumbers 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lottoNumbers)
			.isNotNull()
			.isInstanceOf(LottoNumbers.class)
			.hasNoNullFieldsOrPropertiesExcept("lottoNumbers");
	}
}