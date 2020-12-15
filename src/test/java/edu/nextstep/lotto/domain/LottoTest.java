package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto: 로또 한 장에 해당하는 클래스. 내부적으로 LottoNumbers 필드가 있음.")
class LottoTest {
	@DisplayName("생성자: Lotto 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto)
			.isNotNull()
			.isInstanceOf(Lotto.class)
			.hasNoNullFieldsOrPropertiesExcept("lottoNumbers");
	}
}