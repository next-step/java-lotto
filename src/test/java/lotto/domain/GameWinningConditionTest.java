package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.PrizeGrade.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

class GameWinningConditionTest {

	@DisplayName("getPrizeResult 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingGetPrizeResult")
	void getPrizeResult(GameWinningCondition winningCondition, List<LottoGame> lottoGames, List<PrizeGrade> expect) {
		assertThat(winningCondition.getPrizeResult(lottoGames)).isEqualTo(expect);
	}

	static Stream<Arguments> provideTestingGetPrizeResult() {

		List<LottoNumber> prize = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
				new LottoNumber(4), new LottoNumber(5), new LottoNumber(44));

		LottoNumber bonusNumber = new LottoNumber(6);

		GameWinningCondition gameWinningCondition = new GameWinningCondition(new LottoGame(prize), bonusNumber);

		List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
												new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

		return Stream.of(
				Arguments.of(gameWinningCondition, List.of(new LottoGame(lottoNumbers)), List.of(SECOND))
		);
	}

}
