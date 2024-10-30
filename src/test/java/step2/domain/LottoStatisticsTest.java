package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.var.LottoPrize;

class LottoStatisticsTest {
	private LottoStatistics lottoStatistics;

	@BeforeEach
	void setUp() {
		// 1개 사서 1등 하나 당첨된 경우
		List<LottoNumber> winNumbers = LottoNumber.asList("1, 2, 3, 4, 5, 6");
		Lotto lotto = new Lotto(winNumbers);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(lotto);
		lottoStatistics = new LottoStatistics(lottos, lotto);
	}

	@Test
	@DisplayName("당첨됐을 때 당첨 통계 정보를 체크하는 테스트")
	public void getLottoStastTest() {
		assertThat(lottoStatistics.getWinnerCount(LottoPrize.FIRST_WINNER))
			.isEqualTo(1);
	}
}