package lotto.domain;

import lotto.LottoMatchResultList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

	@Test
	public void 본전케이스_당첨금_계산_테스트() {
		LottoResult lottoResult = new LottoResult();
		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList();
		lottoMatchResultList.add(new LottoMatchResult(3, false));
		lottoMatchResultList.add(new LottoMatchResult(3, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));

		lottoResult.arrangePrize(lottoMatchResultList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(1);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(10000);
	}

	@Test
	public void 손해케이스_당첨금_계산_테스트_손해() {
		LottoResult lottoResult = new LottoResult();
		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList();
		lottoMatchResultList.add(new LottoMatchResult(3, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoResult.arrangePrize(lottoMatchResultList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(0.5);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(5_000);
	}

	@Test
	public void 이익케이스_당첨금_계산_테스트() {
		LottoResult lottoResult = new LottoResult();
		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList();
		lottoMatchResultList.add(new LottoMatchResult(6, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoMatchResultList.add(new LottoMatchResult(1, false));
		lottoResult.arrangePrize(lottoMatchResultList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(200000);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(2_000_000_000);
	}
}