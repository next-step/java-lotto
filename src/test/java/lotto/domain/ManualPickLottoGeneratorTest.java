package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.PurchaseInfo;
import org.junit.Test;

public class ManualPickLottoGeneratorTest {

	@Test
	public void 수동_구매_확인() {
		final int totalPickCount = 10;
		final List<String> manualNumbers = asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "8, 9, 12, 13, 14, 15");
		Money money = new Money(totalPickCount * Lotto.PRICE);
		ManualPickInfo manualPickInfo = new ManualPickInfo(manualNumbers);
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualPickInfo);
		ManualPickLottoGenerator manualPickLottoGenerator = new ManualPickLottoGenerator();

		assertThat(manualPickLottoGenerator.generate(purchaseInfo)).hasSize(manualNumbers.size());
	}
}