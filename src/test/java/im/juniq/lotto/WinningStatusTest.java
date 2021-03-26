package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinningStatusTest {
	@Test
	void matchedStatus() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		List<Lotto> lottoes = lotteryMachine.lottoes(14000);
		WinningStatus winningStatus = new WinningStatus(lottoes, Arrays.asList(1, 2, 3, 4, 5, 6));

		assertThat(winningStatus.numberOfLottoesMatched(3)).isEqualTo(0);
		assertThat(winningStatus.numberOfLottoesMatched(4)).isEqualTo(0);
		assertThat(winningStatus.numberOfLottoesMatched(5)).isEqualTo(0);
		assertThat(winningStatus.numberOfLottoesMatched(6)).isEqualTo(14);
	}
}