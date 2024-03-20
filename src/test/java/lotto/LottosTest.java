package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

	@Test
	@DisplayName("당첨 통계 테스트 - 4등")
	void winningStatisticsTest() {
		List<Integer> lottoNumbers1 = List.of(8, 21, 23, 41, 42, 43);
		List<Integer> winningLottoNumber = List.of(21, 2, 3, 41, 5, 43);
		List<Lotto> inputLottos = List.of(new Lotto(new LottoNumbers(lottoNumbers1)));

		Lottos lottos = new Lottos(inputLottos);

		List<LottoRank> lottoRanks = lottos.getWinningStatistics(winningLottoNumber);

		assertThat(lottoRanks.get(0)).isEqualTo(LottoRank.FOURTH);
	}

}
