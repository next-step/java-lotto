package com.nextstep.lotto.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
	@Test
	void create() {
		LottoFactory lottoFactory = new LottoFactory(3);
		assertThat(lottoFactory).isNotNull();
	}
}
