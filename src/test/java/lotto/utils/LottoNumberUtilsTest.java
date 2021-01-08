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
				LottoNumber.of(1),
				LottoNumber.of(2),
				LottoNumber.of(3),
				LottoNumber.of(4),
				LottoNumber.of(5),
				LottoNumber.of(6)
			);
	}
}
