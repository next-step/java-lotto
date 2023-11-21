package lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

public class LottoValidator {
	private final Set<Integer> winningNumbers;

	public LottoValidator(Set<Integer> winningNumbers) {
		this.winningNumbers = Collections.unmodifiableSet(winningNumbers);
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
