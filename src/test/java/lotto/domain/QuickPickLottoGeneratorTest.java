package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.PurchaseInfo;
import org.junit.Test;

public class QuickPickLottoGeneratorTest {

	@Test
	public void 자동_구매_검증() {
		final int totalPickCount = 10;
		final List<String> manualNumbers = asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "8, 9, 12, 13, 14, 15");
		Money money = new Money(totalPickCount * LottoMachine.LOTTO_PRICE);
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualNumbers);
		QuickPickLottoGenerator quickPickLottoGenerator = new QuickPickLottoGenerator();

		int quickPickCount = totalPickCount - manualNumbers.size();
		assertThat(quickPickLottoGenerator.generate(purchaseInfo)).hasSize(quickPickCount);
	}
}