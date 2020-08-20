package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.factory.WinningBallsFactory;

public class BonusBallTest {

	@Test
	public void bonusBallTest() {
		String lottoNumbersString = "1,2,3,4,5,6";
		WinningBalls winningBalls = WinningBallsFactory.create(lottoNumbersString, "10");

		assertThat(winningBalls).isNotNull();

	}
}
