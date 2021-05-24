package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankCountTest {

	@Test
	@DisplayName("로또 순위 별 개수 가져오기 테스트")
	public void getLottoRankCount() {
		List<LottoRank> lottoRanks = new ArrayList<>();
		lottoRanks.add(LottoRank.FIRST);
		lottoRanks.add(LottoRank.SECOND);
		lottoRanks.add(LottoRank.SECOND);
		lottoRanks.add(LottoRank.THIRD);
		lottoRanks.add(LottoRank.THIRD);
		lottoRanks.add(LottoRank.THIRD);
		lottoRanks.add(LottoRank.FOURTH);
		lottoRanks.add(LottoRank.FOURTH);
		lottoRanks.add(LottoRank.FOURTH);
		lottoRanks.add(LottoRank.FOURTH);
		LottoRankCount lottoRankCount = new LottoRankCount(lottoRanks);
		assertThat(lottoRankCount.getCount(LottoRank.FIRST)).isEqualTo(1);
		assertThat(lottoRankCount.getCount(LottoRank.SECOND)).isEqualTo(2);
		assertThat(lottoRankCount.getCount(LottoRank.THIRD)).isEqualTo(3);
		assertThat(lottoRankCount.getCount(LottoRank.FOURTH)).isEqualTo(4);
	}
}
