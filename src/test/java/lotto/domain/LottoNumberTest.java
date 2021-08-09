package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@Test
	@DisplayName("동일 벨류일 경우 동일 객체")
	void equalLottoNumber() {
		assertThat(LottoNumber.valueOf(1) == LottoNumber.valueOf(1)).isTrue();
	}
}