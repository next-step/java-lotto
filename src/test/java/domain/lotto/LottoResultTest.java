package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoResultTest {

	@Test
	void 수익률을_계산한다() {
		List<Rank> ranks = new ArrayList<>();
		ranks.add(Rank.FOURTH);
		for (int i = 0; i < 13; i++) {
			ranks.add(Rank.MISS);
		}
		LottoResult result = new LottoResult(ranks);
		assertThat(result.profitRate(14000)).isEqualTo(0.35);
	}

	@Test
	void 등수별_개수를_센다() {
		LottoResult result = new LottoResult(List.of(Rank.FOURTH, Rank.MISS, Rank.FOURTH));

		assertThat(result.countOf(Rank.FOURTH)).isEqualTo(2);
		assertThat(result.countOf(Rank.FIRST)).isEqualTo(0);
	}
}
