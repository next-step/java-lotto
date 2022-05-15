package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PurchaseLottoGroup {
	private final List<Lotto> lottoList = new ArrayList<>();

	public PurchaseLottoGroup(long quantity) {
		lottoList.addAll(LongStream.rangeClosed(1, quantity)
			.mapToObj(num -> new Lotto())
			.collect(Collectors.toList()));
	}

	public int size() {
		return lottoList.size();
	}

	public List<LottoRank> ranking(WinningNumber winningNumber) {
		return lottoList.stream()
			.map(lotto -> LottoRank.findBySameQuantity(winningNumber.matchQuantity(lotto)))
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return lottoList.stream()
			.map(Lotto::toString)
			.collect(Collectors.joining("\n"));
	}
}
