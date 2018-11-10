package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.PurchaseInfo;
import lotto.utils.LottoNumberGenerator;

public class ManualPickLottoGenerator implements LottoGenerator {

	@Override
	public List<Lotto> generate(PurchaseInfo purchaseInfo) {
		ManualPickInfo manualPickInfo = purchaseInfo.getManualPickInfo();
		return manualPickInfo.getManualNumbers().stream()
				.map(manualNumber -> LottoNumberGenerator.parse(manualNumber))
				.map(Lotto::new)
				.collect(Collectors.toList());
	}
}
