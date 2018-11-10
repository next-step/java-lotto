package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.PurchaseInfo;
import org.junit.Test;

public class LottoMachineTest {

	@Test
	public void 자동_구매_검증() {
		final int lottoCount = 10;
		Money money = new Money(lottoCount * Lotto.PRICE);
		List<String> manualNumbers = asList("1,2,3,4,5,6");
		ManualPickInfo manualPickInfo = new ManualPickInfo(manualNumbers);
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualPickInfo);
		LottoMachine lottoMachine = new LottoMachine(new QuickPickLottoGenerator());

		LottoTicket lottoTicket = lottoMachine.purchase(purchaseInfo);
		assertThat(lottoTicket.getLottos()).hasSize(lottoCount - manualNumbers.size());
	}

	@Test
	public void 수동_구매_검증() {
		final int lottoCount = 10;
		Money money = new Money(lottoCount * Lotto.PRICE);
		List<String> manualNumbers = asList("1,2,3,4,5,6");
		ManualPickInfo manualPickInfo = new ManualPickInfo(manualNumbers);
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualPickInfo);
		LottoMachine lottoMachine = new LottoMachine(new ManualPickLottoGenerator());

		LottoTicket lottoTicket = lottoMachine.purchase(purchaseInfo);
		assertThat(lottoTicket.getLottos()).hasSize(manualNumbers.size());
	}
}