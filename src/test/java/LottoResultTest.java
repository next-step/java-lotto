import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

	LottoResult lottoResult;

	@BeforeEach
	void setUp(){
		Map<LottoRewardType, Integer> lottoRewardMap = new EnumMap(LottoRewardType.class);
		lottoRewardMap.put(LottoRewardType.PLACE_4TH, LottoRewardType.PLACE_4TH.reward() * 4);
		lottoRewardMap.put(LottoRewardType.PLACE_3TH, LottoRewardType.PLACE_3TH.reward() * 3);
		lottoRewardMap.put(LottoRewardType.PLACE_1TH, LottoRewardType.PLACE_1TH.reward());
		lottoResult = new LottoResult(lottoRewardMap);
	}

	@Test
	void sumTest() {
		// given
		lottoResult.add(3); // PLACE_4TH
		lottoResult.add(5); // PLACE_2TH

		// when
		assertThat(lottoResult.sum(LottoRewardType.PLACE_4TH))
			.isEqualTo(LottoRewardType.PLACE_4TH.reward() * 5);

		assertThat(lottoResult.sum(LottoRewardType.PLACE_3TH))
			.isEqualTo(LottoRewardType.PLACE_3TH.reward() * 3);

		assertThat(lottoResult.sum(LottoRewardType.PLACE_2TH))
			.isEqualTo(LottoRewardType.PLACE_2TH.reward() * 1);

		assertThat(lottoResult.sum(LottoRewardType.PLACE_1TH))
			.isEqualTo(LottoRewardType.PLACE_1TH.reward() * 1);

		assertThat(lottoResult.sum(LottoRewardType.NONE))
			.isEqualTo(0);
	}
}
