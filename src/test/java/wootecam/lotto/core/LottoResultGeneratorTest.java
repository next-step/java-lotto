package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoNumber;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;

public class LottoResultGeneratorTest {

	@Test
	@DisplayName("로또 세트에 대해 로또 결과 통계가 정상적으로 반환되는지 테스트")
	void test_전체로또세트에대해결과통계테스트() {
		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
		Lotto winningLotto = this.generateLotto(1, 2, 3, 4, 5, 6);

		List<Lotto> lottos = new ArrayList<>();
		Lotto lotto = this.generateLotto(2, 3, 4, 5, 6, 45);
		Lotto lotto1 = this.generateLotto(1, 2, 3, 4, 44, 45);
		Lotto lotto2 = this.generateLotto(4, 5, 6, 43, 44, 45);
		Lotto lotto3 = this.generateLotto(2, 3, 4, 5, 6, 1);
		lottos.add(lotto);
		lottos.add(lotto1);
		lottos.add(lotto2);
		lottos.add(lotto3);

		LottoScoreMap lottoScoreMap = lottoResultGenerator.getLottoResults(lottos, winningLotto);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.FIVE_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.FOUR_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.THREE_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.SIX_MATCHING)).isEqualTo(1);
		assertThat(lottoScoreMap.getLottoScores().get(LottoResult.DEFEAT)).isEqualTo(0);
	}

	private Lotto generateLotto(Integer... integers) {
		return new Lotto(Arrays.stream(integers).map(LottoNumber::new).collect(Collectors.toList()));
	}
}
