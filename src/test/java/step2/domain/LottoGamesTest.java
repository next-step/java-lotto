package step2.domain;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGamesTest {

	@DisplayName("로또 게임들 당첨 결과 확인")
	@ParameterizedTest
	@MethodSource("provideMethod")
	void confirmPrize(LottoGames lottoGames, LottoGame prize, List<ConfirmResult> expect) {
		assertThat(lottoGames.confirmPrize(prize)).isEqualTo(new ConfirmResults(expect));
	}

	static Stream<Arguments> provideMethod() {

		String[] oneToSeven = IntStream.range(1, 7).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
		String[] sevenToThirteen = IntStream.range(7, 13).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
		String[] thirteenToNineteen = IntStream.range(13, 19).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});

		ConfirmResult allMatch = new ConfirmResult(6);
		ConfirmResult nonMatch1 = new ConfirmResult(0);
		ConfirmResult nonMatch2 = new ConfirmResult(0);

		return Stream.of(
				Arguments.of(new LottoGames(List.of(new LottoGame(oneToSeven), new LottoGame(sevenToThirteen), new LottoGame(thirteenToNineteen))),
						new LottoGame(oneToSeven),
						List.of(allMatch, nonMatch1, nonMatch2)
						)
		);
	}
}