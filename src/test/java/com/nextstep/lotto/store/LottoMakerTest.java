package com.nextstep.lotto.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoMakerTest {
	@Test
	void create() {
		LottoMaker lottoMaker = new LottoMaker(3);
		assertThat(lottoMaker).isNotNull();
	}
}
