package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

	LottoResult lottoResult;

	@BeforeEach
	void setUp() {
		List<LottoRank> lottoRankList = new ArrayList<>();
		lottoRankList.add(LottoRank.FOURTH);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoRankList.add(LottoRank.UNRANKED);
		lottoResult = new LottoResult(lottoRankList);
	}

	@Test
	@DisplayName("로또 결과 생성 테스트")
	public void getLottoResultTest() {
		assertThat(lottoResult).isNotNull();
	}

	@Test
	@DisplayName("로또 결과 보상 값 테스트")
	public void getTotalReward() {
		assertThat(lottoResult.getTotalReward()).isEqualTo(5000);
	}

	@Test
	@DisplayName("로또 결과 수익률 테스트")
	public void getYield() {
		assertThat(lottoResult.getYield()).isEqualTo(0.35);
	}

	@Test
	@DisplayName("로또 결과 순위 별 개수 테스트")
	public void getLottoRankCount() {
		assertThat(lottoResult.getLottoRankCount().getFirstCount()).isEqualTo(0);
		assertThat(lottoResult.getLottoRankCount().getSecondCount()).isEqualTo(0);
		assertThat(lottoResult.getLottoRankCount().getThirdCount()).isEqualTo(0);
		assertThat(lottoResult.getLottoRankCount().getFourthCount()).isEqualTo(1);
	}

}
