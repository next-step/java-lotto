package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(final LottoPrice lottoPrice) {
		this.lottos = generate(lottoPrice.getNumberOfPurchasesPerUnitPrice());
	}

	private List<Lotto> generate(final int size) {
		List<Lotto> lottos = new ArrayList<>(size);
		while (lottos.size() < size) {
			lottos.add(new Lotto());
		}
		return lottos;
	}

	public int size() {
		return this.lottos.size();
	}
}
