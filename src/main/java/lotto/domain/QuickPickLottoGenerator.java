package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.PurchaseInfo;
import lotto.utils.LottoNumberGenerator;

public class QuickPickLottoGenerator implements LottoGenerator {

	@Override
	public List<Lotto> generate(PurchaseInfo purchaseInfo) {
		int quickPickCount = getQuickPickCount(purchaseInfo);
		List<Lotto> lottos = new ArrayList<>();
		for(int count = 1; count <= quickPickCount; count++) {
			lottos.add(getLotto());
		}
		return lottos;
	}

	private int getQuickPickCount(PurchaseInfo purchaseInfo) {
		Money money = purchaseInfo.getMoney();
		ManualPickInfo manualPickInfo = purchaseInfo.getManualPickInfo();
		return money.getTotalPickCount() - manualPickInfo.getPickCount();
	}

	private Lotto getLotto() {
		return new Lotto(LottoNumberGenerator.pick());
	}
}
