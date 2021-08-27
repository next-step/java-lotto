package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGroup {
	private final List<Lotto> lottoGroup;

	public LottoGroup(List<List<Integer>> lottoNumbers) {
		this.lottoGroup = lottoNumbers
			.stream()
			.map(list -> new Lotto(list))
			.collect(Collectors.toList());
	}

	public LottoGroup(List<List<Integer>> lottoNumbers, int lottoPrice, int lottoNumberCount) {
		this.lottoGroup = lottoNumbers
			.stream()
			.map(list -> new Lotto(list, lottoPrice, lottoNumberCount))
			.collect(Collectors.toList());
	}

	public LottoReport lottoResultReport(List<Integer> winningNumbers) {
		return new LottoReport(
			this.lottoGroup
				.stream()
				.map(lotto -> lotto.unmaskedLotto(new Lotto(winningNumbers)).lottoRank())
				.collect(Collectors.toList()), Lotto.DEFAULT_PRICE);
	}
}
