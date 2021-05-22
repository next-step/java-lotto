package com.nextstep.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoStoreTest {

	@DisplayName("구입금액이 1,000원 이상인지 테스트")
	@Test
	void 구입금액_범위_테스트() {
		assertThatThrownBy(() -> new LottoStore(900))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입금액에 맞게 로또개수를 주는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "2000:2", "10000:10", "5500:5"}, delimiter = ':')
	void 구입금액에_맞는_로또개수를_반환하는지_테스트(int money, int lottoCount) {
		LottoStore lottoStore = new LottoStore(money);
		assertThat(lottoStore.lottoCount()).isEqualTo(lottoCount);
	}
}
