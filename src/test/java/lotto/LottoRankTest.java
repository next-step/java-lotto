package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

	@Test
	public void matchesRankTest() {
		assertThat(LottoRank.FIRST.matches()).isEqualTo(6);
		assertThat(LottoRank.SECOND.matches()).isEqualTo(5);
		assertThat(LottoRank.THIRD.matches()).isEqualTo(4);
		assertThat(LottoRank.FORTH.matches()).isEqualTo(3);
	}
}
