package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottosTest {

	@ParameterizedTest
	@CsvSource({
			"21, 2, 3, 8, 9, 10, 1, FIFTH, 1",
			"21, 2, 3, 41, 9, 10, 1, FOURTH, 1",
			"21, 2, 3, 41, 5, 10, 1, THIRD, 1",
			"21, 2, 3, 41, 5, 10, 10, SECOND, 1",
			"21, 2, 3, 41, 5, 43, 1, FIRST, 1"
	})
	@DisplayName("당첨 통계 테스트 - 1,2,3,4,5등 검증")
	void winningStatisticsTest(int number1, int number2, int number3, int number4, int number5, int number6, int bonusNumber, String key, int expectedMatchCount) {
		List<Integer> lottoNumbers = List.of(number1, number2, number3, number4, number5, number6);
		List<Integer> winningLottoNumber = List.of(21, 2, 3, 41, 5, 43);

		List<LottoNumbers> inputLottos = List.of(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(inputLottos);

		Map<LottoRank, Integer> lottoRanks = lottos.getWinningStatistics(new WinningLottoNumber(new LottoNumbers(winningLottoNumber), new LottoNumber(bonusNumber)));
		LottoRank expectedRank = LottoRank.valueOf(key);

		assertThat(lottoRanks.get(expectedRank)).isEqualTo(expectedMatchCount);
	}

	@Test
	@DisplayName("로또번호와 보너스볼 중복일 시 예외 처리 테스트")
	void bonusNumberDuplicationExceptionTest() {
		assertThatThrownBy(() -> {
			List<Integer> lottoNumbers = List.of(21, 2, 3, 41, 5, 40);
			List<Integer> winningLottoNumber = List.of(21, 2, 3, 41, 5, 43);

			List<LottoNumbers> inputLottos = List.of(new LottoNumbers(lottoNumbers));
			Lottos lottos = new Lottos(inputLottos);

			lottos.getWinningStatistics(new WinningLottoNumber(new LottoNumbers(winningLottoNumber), new LottoNumber(41)));
		})
				.isInstanceOf(IllegalArgumentException.class);

	}

}
