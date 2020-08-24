package step3.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticTest {
	private static Lotto winningLotto;
	private static int winningBonus;
	private static List<Lotto> lottos;

	private static Lotto getLotto(Integer[] nums) {
		return new Lotto(
				Arrays.stream(nums)
						.map(LottoNumber::new)
						.collect(Collectors.toList())
		);
	}

	@BeforeAll
	static void setWinningInfo() {
		List<Integer[]> nums = Arrays.asList(
				new Integer[] {9, 20, 32, 37, 43, 45},
				new Integer[] {8, 17, 34, 35, 37, 40},
				new Integer[] {1, 9, 10, 14, 16, 40},       // 4
				new Integer[] {3, 6, 10, 14, 24, 40},       // 5 BONUS
				new Integer[] {5, 11, 17, 26, 39, 42},
				new Integer[] {10, 12, 17, 30, 37, 42},
				new Integer[] {3, 6, 10, 14, 16, 40},       // 6
				new Integer[] {2, 6, 9, 15, 32, 36}
		);

		lottos = new ArrayList<>();
		for (Integer[] num : nums) {
			lottos.add(getLotto(num));
		}

		int[] winning = new int[] {3, 6, 10, 14, 16, 40};
		List<LottoNumber> winningNumbers = Arrays.stream(winning)
				.mapToObj(LottoNumber::new)
				.collect(Collectors.toList());
		winningLotto = new Lotto(winningNumbers);
		winningBonus = 24;
	}

	@DisplayName(value = "로또 당첨 통계 테스트")
	@Test
	void calcLottoResult() {
		Map<Rank, Integer> result = new LottoStatistic(winningLotto, winningBonus)
				.calcLottoResult(lottos);

		assertThat(result).containsEntry(Rank.BONUS, 1);
		assertThat(result).containsEntry(Rank.SIX, 1);
		assertThat(result).containsEntry(Rank.FOUR, 1);
		assertThat(result).containsEntry(Rank.NOTHING, 5);
	}

}