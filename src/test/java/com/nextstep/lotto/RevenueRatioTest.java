package com.nextstep.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.nextstep.lotto.result.LottoMatch;
import com.nextstep.lotto.result.RevenueRatio;
import com.nextstep.lotto.store.LottoStore;

public class RevenueRatioTest {

	@DisplayName("일치하는 개수에 맞게 수익률을 계산하는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3000:3:5000", "10000:3:5000", "10000:4:50000", "10000:5:1500000"}, delimiter = ':')
	void 수익률_테스트(int money, int resultCount, int revenue) {
		LottoStore lottoStore = new LottoStore(money);
		List<LottoMatch> lottoMatches = new ArrayList<>();
		lottoMatches.add(new LottoMatch(resultCount));

		RevenueRatio revenueRatio = new RevenueRatio(lottoStore.getMoney(), lottoMatches);
		assertThat(revenueRatio.calculate()).isEqualTo(revenue / (double)money);
	}
}
