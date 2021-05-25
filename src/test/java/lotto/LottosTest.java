package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
	@ParameterizedTest(name = "[{index}] {0}개의 숫자가 일치하는 로또는 {1}개 인 당첨 결과를 반환한다")
	@CsvSource(value = {"6:1", "5:3", "4:2", "3:1", "0:2"}, delimiter = ':')
	void lottosGetWinningResultTest(int matchedNumberCount, int lottoCount) {
		Lottos lottos = new Lottos(Arrays.asList(
				new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
				new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7)),
				new Lotto(Arrays.asList(1, 22, 33, 4, 6, 7)),
				new Lotto(Arrays.asList(10, 20, 30, 40, 16, 17)),
				new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7)),
				new Lotto(Arrays.asList(1, 2, 23, 22, 26, 7)),
				new Lotto(Arrays.asList(1, 2, 3, 4, 36, 37)),
				new Lotto(Arrays.asList(1, 2, 3, 4, 26, 27)),
				new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7))));

		List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

		LottoResult result = lottos.getWinningResult(winningNumber);
		assertThat(result.getNumberOfLottosMatchedWith(matchedNumberCount)).isEqualTo(lottoCount);
	}
}
