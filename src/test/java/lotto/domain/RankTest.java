package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class RankTest {
	@Test
	@DisplayName("2등 RANK 구하기")
	void findRank() {
		assertTrue(Rank.findRank(5) == Rank.RANK2);
	}
}
