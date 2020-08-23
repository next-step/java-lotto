package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.factory.WinningBallsFactory;

public class BonusBallTest {

	@Test
	public void bonusBallTest() {
		String lottoNumbersString = "1,2,3,4,5,6";
		WinningBalls winningBalls = WinningBallsFactory.create(lottoNumbersString, "10");

		assertThat(winningBalls).isNotNull();
	}

	@ParameterizedTest
	@MethodSource("winningBallParameterProvider")
	public void getAllWinningNumbersTest(WinningBalls winningBalls, Integer[] except) {
		assertThat(winningBalls.getAllWinningNumbers()).containsExactly(except);
	}

	@ParameterizedTest
	@MethodSource("bonusBallParameterProvider")
	public void isSameNumberIncludedWithBonusBallTest(WinningBalls winningBalls, Lotto lotto, boolean except) {
		assertThat(winningBalls.isSameNumberIncludedWithBonusBall(lotto)).isEqualTo(except);
	}

	private static Stream<Arguments> winningBallParameterProvider() {

		WinningBalls winningBalls = WinningBalls.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
													BonusBall.of("10"));
		WinningBalls winningBalls2 = WinningBalls.of(Lotto.of(Arrays.asList(10, 14, 24, 33, 37, 45)),
													 BonusBall.of("17"));
		WinningBalls winningBalls3 = WinningBalls.of(Lotto.of(Arrays.asList(8, 12, 17, 39, 40, 44)),
													 BonusBall.of("45"));

		return Stream.of(Arguments.arguments(winningBalls, new Integer[]{1, 2, 3, 4, 5, 6, 10}),
						 Arguments.arguments(winningBalls2, new Integer[]{10, 14, 24, 33, 37, 45, 17}),
						 Arguments.arguments(winningBalls3, new Integer[]{8, 12, 17, 39, 40, 44, 45})
						);
	}

	private static Stream<Arguments> bonusBallParameterProvider() {

		WinningBalls winningBalls = WinningBalls.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
													BonusBall.of("10"));
		WinningBalls winningBalls2 = WinningBalls.of(Lotto.of(Arrays.asList(10, 14, 24, 33, 37, 45)),
													 BonusBall.of("17"));
		WinningBalls winningBalls3 = WinningBalls.of(Lotto.of(Arrays.asList(8, 12, 17, 39, 40, 44)),
													 BonusBall.of("45"));

		return Stream.of(Arguments.arguments(winningBalls, Lotto.of(Arrays.asList(8, 10, 20, 39, 40, 45)), Boolean.TRUE),
						 Arguments.arguments(winningBalls2, Lotto.of(Arrays.asList(8, 10, 20, 39, 40, 45)), Boolean.FALSE),
						 Arguments.arguments(winningBalls3, Lotto.of(Arrays.asList(8, 10, 20, 39, 40, 45)), Boolean.TRUE)
						);
	}


}
