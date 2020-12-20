package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(final LottoPrice lottoPrice) {
		this.lottos = generate(lottoPrice);
	}

	private List<Lotto> generate(final LottoPrice lottoPrice) {
		List<Lotto> lottos = new ArrayList<>(lottoPrice.getNumberOfPurchasesPerUnitPrice());
		while (lottos.size() < lottoPrice.getNumberOfPurchasesPerUnitPrice()) {
			lottos.add(new Lotto(LottoNumberGenerator.generate()));
		}
		return lottos;
	}

	public int size() {
		return this.lottos.size();
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
