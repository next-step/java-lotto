package lotto.domain;

import java.util.List;
import lotto.dto.PurchaseInfo;

public interface LottoGenerator {

	List<Lotto> generate(PurchaseInfo purchaseInfo);
}
