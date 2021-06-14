package com.nextstep.lotto.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

	@ParameterizedTest
	@ValueSource(ints = {1000, 3000, 15500})
	void 구입한_로또개수(int money) {
		LottoStore lottoStore = new LottoStore(money, 0);
		assertThat(lottoStore.autoLottoCount()).isEqualTo(money / 1000);
	}

	@Test
	void 천원보다_작은금액일때_exception() {
		assertThatThrownBy(() ->
			new LottoStore(500, 0)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 수동로또_개수_입력후_남은금액은_자동로또() {
		LottoStore lottoStore = new LottoStore(5000, 1);
		assertThat(lottoStore.autoLottoCount()).isEqualTo(4);
	}
}
