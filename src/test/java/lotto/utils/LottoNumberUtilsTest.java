package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;

class LottoNumberUtilsTest {
	@Test
	void mapToListByComma_test() {
		assertThat(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6"))
			.hasSize(6)
			.containsExactly(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			);
	}
}
