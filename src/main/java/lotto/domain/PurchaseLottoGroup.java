package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PurchaseLottoGroup {
	private final List<Lotto> lottoGroup;

	public PurchaseLottoGroup(long quantity) {
		lottoGroup =LongStream.rangeClosed(1, quantity)
			.mapToObj(num -> Lotto.createAuto())
			.collect(Collectors.toList());
	}

	public int size() {
		return lottoGroup.size();
	}

	public List<LottoRank> ranking(WinningNumbers winningNumbers) {
		return lottoGroup.stream()
			.map(winningNumbers::ranking)
			.collect(Collectors.toList());
	}

	public List<Lotto> values() {
		return lottoGroup;
	}
}
