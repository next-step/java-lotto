package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

public class LottoValidator {
	private final Set<LottoNumber> winningNumbers;

	public LottoValidator(Set<Integer> winningNums) {
		winningNumbers = new LinkedHashSet<>();
		for (Integer winningNum : winningNums) {
			winningNumbers.add(new LottoNumber(winningNum));
		}
	}

	public LottoValidator(int... nums) {
		winningNumbers = new LinkedHashSet<>();
		for (int num : nums) {
			winningNumbers.add(new LottoNumber(num));
		}
	}

	public Rank valid(LottoTicket lottoTicket) {
		return Rank.matchRank(
			(int) winningNumbers.stream()
				.filter(
					wn -> lottoTicket.getNumbers().stream()
						.anyMatch(Predicate.isEqual(wn))
				)
				.count()
		);
	}
}
