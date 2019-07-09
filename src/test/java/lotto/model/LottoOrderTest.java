package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoOrderTest {

	List<LottoNumberSet> manualOrderList;


	@BeforeEach
	void setManualOrderList(){
		manualOrderList = new ArrayList<>();
		manualOrderList.add(LottoNumberSet.of(new int[]{1, 2, 3, 4, 5, 6}));
		manualOrderList.add(LottoNumberSet.of(new int[]{1, 2, 3, 7, 8, 9}));
		manualOrderList.add(LottoNumberSet.of(new int[]{1, 2, 3, 7, 8, 9}));
	}

	@DisplayName("정상주문")
	@Test
	void lessThanInputManualCount() {
		int investment = 10000;
		LottoOrder order = new LottoOrder(investment, manualOrderList);

		assertThat(order.getManualOrders().size()).isEqualTo(3);
	}

	@DisplayName("수동구매비용이 투자금을 초과하는 경우")
	@Test
	void manualCountOverInvestment() {
		int investment = 1000;

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new LottoOrder(investment, manualOrderList);
		});
	}

	@DisplayName("수동구매를 제외한 자동구매 수량 확인")
	@Test
	void balance(){
		int investment = 10000;
		LottoOrder order = new LottoOrder(investment, manualOrderList);

		assertThat(order.getAutoOrderCount()).isEqualTo(7);
	}
}