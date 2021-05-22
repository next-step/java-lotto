package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;

public class LottoResultGeneratorTest {

	@Test
	@DisplayName("로또 세트에 대해 로또 결과 통계가 정상적으로 반환되는지 테스트")
	void test_전체로또세트에대해결과통계테스트() {
		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<Lotto> lottos = new ArrayList<>();
		Lotto lotto1 = new Lotto(Arrays.asList(45, 2, 3, 4, 5, 6));
		lottos.add(lotto1);
		Lotto lotto2 = new Lotto(Arrays.asList(45, 44, 3, 4, 5, 6));
		lottos.add(lotto2);
		Lotto lotto3 = new Lotto(Arrays.asList(45, 44, 43, 4, 5, 6));
		lottos.add(lotto3);
		Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		lottos.add(lotto4);

		LottoScoreMap lottoScoreMap = lottoResultGenerator.getLottoResults(lottos, winningLotto);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.FIVE_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.FOUR_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.THREE_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.SIX_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.DEFEAT)).isEqualTo(0);

	}
}
