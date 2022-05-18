package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PurchaseLottoGroup {
	private final List<Lotto> lottoGroup = new ArrayList<>();

	public PurchaseLottoGroup(long quantity) {
		lottoGroup.addAll(LongStream.rangeClosed(1, quantity)
			.mapToObj(num -> new Lotto())
			.collect(Collectors.toList()));
	}

	public PurchaseLottoGroup(List<String> inputLottoList) {
		lottoGroup.addAll(inputLottoList.stream()
			.map(Lotto::new)
			.collect(Collectors.toList()));
	}

	public int size() {
		return lottoGroup.size();
	}

	public List<LottoRank> ranking(WinningNumber winningNumber) {
		return lottoGroup.stream()
			.map(lotto -> LottoRank.findBySameQuantity(winningNumber.matchQuantity(lotto)))
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return lottoGroup.stream()
			.map(Lotto::toString)
			.collect(Collectors.joining("\n"));
	}
}
