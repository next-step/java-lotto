package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LottoValidator {
	private final List<Integer> winningNumbers;

	public LottoValidator(List<Integer> winningNumbers) {
		this.winningNumbers = Collections.unmodifiableList(winningNumbers);
	}

	public LottoTicket valid(LottoTicket lottoTicket) {
		int sameNumbers = (int) winningNumbers.stream()
			.filter(
				wn -> lottoTicket.getNumbersToList().stream()
					.anyMatch(Predicate.isEqual(wn))
			)
			.count();

		lottoTicket.updateRank(Rank.matchRank(sameNumbers));
		return lottoTicket;
	}
}
