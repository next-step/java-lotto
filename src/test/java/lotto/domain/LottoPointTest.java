package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoPointTest {

	@Test
	void equals() {
		assertThat(new LottoPoint(1, false)).isEqualTo(new LottoPoint(1, false));
		assertThat(new LottoPoint(1, true)).isEqualTo(new LottoPoint(1, true));

		assertThat(new LottoPoint(1, true)).isNotEqualTo(new LottoPoint(1, false));
		assertThat(new LottoPoint(1, true)).isNotEqualTo(new LottoPoint(1, false));
	}
}
