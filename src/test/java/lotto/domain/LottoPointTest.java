package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoPointTest {

	@Test
	void equals() {
		assertThat(new LottoPoint(1)).isEqualTo(new LottoPoint(1));
		assertThat(new LottoPoint(1, true)).isEqualTo(new LottoPoint(1, true));

		assertThat(new LottoPoint(1, true)).isNotEqualTo(new LottoPoint(1, false));
		assertThat(new LottoPoint(1, true)).isNotEqualTo(new LottoPoint(1, false));
	}
}
