package wootecam.lotto.core;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoResult;

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

}
