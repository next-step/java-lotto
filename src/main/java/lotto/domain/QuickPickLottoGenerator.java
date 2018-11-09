package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.PurchaseInfo;
import lotto.utils.LottoNumberGenerator;

public class QuickPickLottoGenerator implements LottoGenerator {

	@Override
	public List<Lotto> generate(PurchaseInfo purchaseInfo) {
		List<Lotto> lottos = new ArrayList<>();
		for(int count = 1; count <= purchaseInfo.getQuickPickCount(); count++) {
			lottos.add(getLotto());
		}
		return lottos;
	}

	private Lotto getLotto() {
		return new Lotto(LottoNumberGenerator.pick());
	}
}
