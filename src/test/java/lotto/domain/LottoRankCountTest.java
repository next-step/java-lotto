package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankCountTest {

	@Test
	@DisplayName("로또 순위 별 개수 가져오기 테스트")
	public void getLottoRankCount() {
		Map<LottoRank, Long> lottoRankLongMap = new HashMap<>();
		lottoRankLongMap.put(LottoRank.FIRST, 1L);
		lottoRankLongMap.put(LottoRank.SECOND, 2L);
		lottoRankLongMap.put(LottoRank.THIRD, 3L);
		lottoRankLongMap.put(LottoRank.FOURTH, 4L);
		LottoRankCount lottoRankCount = new LottoRankCount(lottoRankLongMap);
		assertThat(lottoRankCount.getCount(LottoRank.FIRST)).isEqualTo(1);
		assertThat(lottoRankCount.getCount(LottoRank.SECOND)).isEqualTo(2);
		assertThat(lottoRankCount.getCount(LottoRank.THIRD)).isEqualTo(3);
		assertThat(lottoRankCount.getCount(LottoRank.FOURTH)).isEqualTo(4);
	}
}
