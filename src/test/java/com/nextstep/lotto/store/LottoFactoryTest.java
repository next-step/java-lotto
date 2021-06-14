package com.nextstep.lotto.store;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.nextstep.lotto.lotto.Lotto;
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
	void create_auto_lottos() {
		RandomNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
		LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
		Lottos lottos = lottoFactory.create(3);
		assertThat(lottos).isNotNull();
	}

	@Test
	void create_manual_lottos() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		LottoFactory lottoFactory = new LottoFactory(randomNumberGenerator);

		Lotto lotto1 = new Lotto(randomNumberGenerator.makeNumbers());
		Lotto lotto2 = new Lotto(randomNumberGenerator.makeNumbers());
		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(lotto1);
		lottoList.add(lotto2);

		Lottos lottos = lottoFactory.createManualLottos(lottoList);
		assertThat(lottos).isNotNull();
		assertThat(lottos.userLottos().size()).isEqualTo(2);
	}
}
