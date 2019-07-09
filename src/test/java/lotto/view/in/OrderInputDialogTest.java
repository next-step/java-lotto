package lotto.view.in;

import lotto.model.LottoOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderInputDialogTest {

	@DisplayName("수동선택이 없는 주문서 작성")
	@Test
	void makeOrder() {

		List<String> messages = new ArrayList<>();
		LinkedList<String> inputValues = new LinkedList<>();
		inputValues.add("1000"); // 구입금액
		inputValues.add("0"); // 수동 구매 수


		OrderInputDialog dialog = new OrderInputDialog(
				message -> messages.add(message),
				() -> inputValues.pollFirst()
		);

		LottoOrder order = dialog.makeOrder();

		assertThat(order.getAutoOrderCount()).isEqualTo(1);
		assertThat(order.getManualOrders().size()).isEqualTo(0);

	}
}