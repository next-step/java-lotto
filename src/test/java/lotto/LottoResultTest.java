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
	void setUp(){
		Map<LottoRewardType, Integer> lottoRewardMap = new EnumMap(LottoRewardType.class);
		lottoRewardMap.put(LottoRewardType.PLACE_4TH, 4);
		lottoRewardMap.put(LottoRewardType.PLACE_3TH, 3);
		lottoRewardMap.put(LottoRewardType.PLACE_1TH, 1);
		lottoResult = new LottoResult(lottoRewardMap);
	}

	@Test
	@DisplayName("당첨 결과 집계 테스트")
	void countTest() {
		// given
		lottoResult.add(3); // PLACE_4TH
		lottoResult.add(5); // PLACE_2TH

		// when
		assertThat(lottoResult.count(LottoRewardType.PLACE_4TH))
			.isEqualTo(5);

		assertThat(lottoResult.count(LottoRewardType.PLACE_3TH))
			.isEqualTo(3);

		assertThat(lottoResult.count(LottoRewardType.PLACE_2TH))
			.isEqualTo(1);

		assertThat(lottoResult.count(LottoRewardType.PLACE_1TH))
			.isEqualTo(1);

		assertThat(lottoResult.count(LottoRewardType.NONE))
			.isEqualTo(0);
	}
}
