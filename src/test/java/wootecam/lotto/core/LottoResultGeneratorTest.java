package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;

public class LottoResultGeneratorTest {
	@Test
	void testLottoResult() {
		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
	}

	@Test
	void test_로또6개모두매칭확인() {
		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
		Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoResult lottoResult = lottoResultGenerator.getLottoResult(myLotto, winningLotto);
		Assertions.assertThat(lottoResult).isEqualTo(LottoResult.SIX_MATCHING);
	}

	@Test
	void test_로또번호가몇개맞았는지테스트() {
		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
		Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		int matchedCount = lottoResultGenerator.getMatchCount(myLotto, winningLotto);
		Assertions.assertThat(matchedCount).isEqualTo(6);
	}

	@Test
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

	}

}
