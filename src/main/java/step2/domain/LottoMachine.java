package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

	public static Lottos issue(final LottoPrice lottoPrice) {
		List<Lotto> lottos = new ArrayList<>();
		while (lottos.size() < lottoPrice.getNumberOfPurchasesPerUnitPrice()) {
			lottos.add(new Lotto(LottoNumberGenerator.generate()));
		}
		return new Lottos(lottos);
	}

}
