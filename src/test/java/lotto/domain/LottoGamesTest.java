package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.PrizeGrade.*;

class LottoGamesTest {

	@DisplayName("로또 게임들 당첨 결과 확인")
	@ParameterizedTest
	@MethodSource("provideMethod")
	void confirmPrize(LottoGames lottoGames, PrizeInfo prize, List<PrizeGrade> expect) {
		assertThat(lottoGames.confirmPrize(prize)).isEqualTo(new ConfirmResults(expect));
	}

	static Stream<Arguments> provideMethod() {

		String[] oneToSix = IntStream.range(1, 7).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
		String[] oneToFiveAndNine = IntStream.of(1,2,3,4,5,9).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
		String[] oneToFiveAndEight = IntStream.of(1,2,3,4,5,8).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
		String[] sevenToTwelve = IntStream.range(7, 13).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
		String[] thirteenToEighteen = IntStream.range(13, 19).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});

		LottoNumber bonus = new LottoNumber(9);

		return Stream.of(
				Arguments.of(new LottoGames(List.of(new LottoGame(oneToSix), new LottoGame(oneToFiveAndNine), new LottoGame(oneToFiveAndEight), new LottoGame(sevenToTwelve), new LottoGame(thirteenToEighteen))),
						new PrizeInfo(new LottoGame(oneToSix), bonus),
						List.of(FIRST, SECOND, THIRD, FAIL, FAIL)
						)
		);
	}
}
