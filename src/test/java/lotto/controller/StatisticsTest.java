package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {
	@DisplayName("등수마다 일치하는 로또 개수 반환.")
	@Test
	void 등수마다_일치하는_로또_개수() {
		int[] numbersOfMatch = {1, 2, 3, 4, 5};
		int[] result = Statistics.calculate(numbersOfMatch);
		assertThat(result[2]==1).isTrue();
	}
}
