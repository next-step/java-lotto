package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

	@DisplayName("로또 결과를 집계한다.")
	@Test
	void aggregate_result() {
		List<Rank> ranks = List.of(Rank.THIRD, Rank.FOURTH, Rank.FOURTH, Rank.FIFTH, Rank.FIFTH, Rank.FIFTH, Rank.NOT);

		EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
		result.put(Rank.FIRST, 0);
		result.put(Rank.SECOND, 0);
		result.put(Rank.THIRD, 1);
		result.put(Rank.FOURTH, 2);
		result.put(Rank.FIFTH, 3);
		result.put(Rank.NOT, 1);

		assertThat(new Result().aggregateResult(ranks)).isEqualTo(result);
	}

	@DisplayName("로또 수익률을 계산한다")
	@Test
	void calc_return_rate() {
		EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
		result.put(Rank.FIRST, 0);
		result.put(Rank.SECOND, 0);
		result.put(Rank.THIRD, 1);
		result.put(Rank.FOURTH, 2);
		result.put(Rank.FIFTH, 3);
		result.put(Rank.NOT, 1);

		assertThat(new Result(result).calcReturnRate(7)).isEqualTo(302142.0);
	}
}
