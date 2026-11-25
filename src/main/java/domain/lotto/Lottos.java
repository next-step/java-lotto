package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos = new ArrayList<>();

	private static final int LOTTO_PRICE = 1000;

	public Lottos(int money) {
		int lottoCount = money / LOTTO_PRICE;
		LottoGenerator lottoGenerator = new LottoGenerator();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(lottoGenerator.generate());
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
