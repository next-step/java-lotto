package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGroup {
	private final List<Lotto> lottoGroup;

	public LottoGroup(List<Lotto> lottoGroup) {
		this.lottoGroup = lottoGroup;
	}

	public LottoReport lottoResultReport(Lotto winningNumbers) {
		return new LottoReport(
			this.lottoGroup
				.stream()
				.map(lotto -> lotto.unmaskedLotto(winningNumbers).lottoRank())
				.collect(Collectors.toList()), Lotto.DEFAULT_PRICE);
	}
}
