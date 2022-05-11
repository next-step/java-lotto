package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseLottoGroup {
	private final List<Lotto> lottoList;

	public PurchaseLottoGroup() {
		lottoList = new ArrayList<>();
	}

	public PurchaseLottoGroup(int quantity) {
		this();

		lottoList.addAll(IntStream.rangeClosed(1, quantity)
			.mapToObj(num -> new Lotto())
			.collect(Collectors.toList()));
	}

	public int size() {
		return lottoList.size();
	}

}
