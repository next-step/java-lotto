package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

	@ParameterizedTest
	@CsvSource({"3, 5000", "4, 50000", "5, 1500000", "6, 2000000000", "2, 0", "0, 0"})
	void 일치_개수에_맞는_당첨금을_반환한다(int matchCount, int prize) {
		assertThat(Rank.from(matchCount).getPrize()).isEqualTo(prize);
	}
}
