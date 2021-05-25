package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.LottoRewardType;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

	private LottoResult lottoResult;

	@BeforeEach
	void setUp() {
		Map<LottoRewardType, Integer> lottoRewardMap = new EnumMap(LottoRewardType.class);
		lottoRewardMap.put(LottoRewardType.FIFTH, 4);
		lottoRewardMap.put(LottoRewardType.FOURTH, 3);
		lottoRewardMap.put(LottoRewardType.FIRST, 1);
		lottoResult = new LottoResult(lottoRewardMap);
	}

	@Test
	@DisplayName("당첨 결과 집계 테스트")
	void countTest() {
		// given
		lottoResult.add(LottoRewardType.FIFTH); // PLACE_4TH
		lottoResult.add(LottoRewardType.THIRD); // PLACE_2TH

		// when
		assertThat(lottoResult.count(LottoRewardType.FIFTH))
			.isEqualTo(5);

		assertThat(lottoResult.count(LottoRewardType.FOURTH))
			.isEqualTo(3);

		assertThat(lottoResult.count(LottoRewardType.THIRD))
			.isEqualTo(1);

		assertThat(lottoResult.count(LottoRewardType.FIRST))
			.isEqualTo(1);

		assertThat(lottoResult.count(LottoRewardType.NONE))
			.isEqualTo(0);
	}

	@Test
	@DisplayName("수익률 계산 테스트")
	void calculateRevenueTest() {
		// given
		Map<LottoRewardType, Integer> lottoRewardMap = new EnumMap<>(LottoRewardType.class);
		lottoRewardMap.put(LottoRewardType.FIFTH, 2);
		LottoResult lottoResult = new LottoResult(lottoRewardMap);

		// when
		assertThat(lottoResult.calculateRevenue(new LottoMoney(10000)).doubleValue())
			.isEqualTo(1.00); // then

	}
}
