package com.nextstep.lotto.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nextstep.lotto.lotto.LottoFactory;
import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.lotto.RandomNumberGenerator;

public class LottoFactoryTest {
	@Test
	void create() {
		RandomNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
		LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
		assertThat(lottoFactory).isNotNull();
	}

	@Test
	void create_lottos() {
		RandomNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
		LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
		Lottos lottos = lottoFactory.createLottos(3);
		assertThat(lottos).isNotNull();
	}

}
