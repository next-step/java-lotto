package lotto;

import lotto.domain.LotteryStore;
import lotto.domain.LottoWallet;
import lotto.domain.TicketMachine;
import lotto.model.LottoNumberSet;
import lotto.model.LottoOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {

	@DisplayName("수동구입 신청한 번호가 포함된 복권 생성 확인")
	@Test
	void buy() {
		// Arrange
		LottoNumberSet numberSetA = LottoNumberSet.of(new int[]{1, 2, 3, 4, 5, 6});
		LottoNumberSet numberSetB = LottoNumberSet.of(new int[]{7, 8, 9, 10, 11, 12});

		List<LottoNumberSet>  manualOrderList = new ArrayList<>();
		manualOrderList.add(numberSetA);
		manualOrderList.add(numberSetB);

		LotteryStore store = new LotteryStore(new TicketMachine());
		LottoOrder order = new LottoOrder(10000, manualOrderList);

		// Action
		LottoWallet wallet = store.buy(order);

		// Assertion
		assertThat(wallet.ticketCount()).isEqualTo(10);
		assertThat(wallet.containsTicketHasNumbers(numberSetA)).isTrue();
		assertThat(wallet.containsTicketHasNumbers(numberSetB)).isTrue();
	}
}