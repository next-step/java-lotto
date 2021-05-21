package lotto.rank;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.LottoScratcher;

public class LottoScratcherTest {

	@Test
	public void scratchLottoByMatches() {
		assertThat(LottoScratcher.scratchLotto(6).getClass()).isEqualTo(FirstPlace.class);
		assertThat(LottoScratcher.scratchLotto(5).getClass()).isEqualTo(SecondPlace.class);
		assertThat(LottoScratcher.scratchLotto(4).getClass()).isEqualTo(ThirdPlace.class);
		assertThat(LottoScratcher.scratchLotto(3).getClass()).isEqualTo(FourthPlace.class);
	}
}
