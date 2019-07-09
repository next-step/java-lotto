package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.TicketMachine;
import lotto.model.LottoOrder;
import lotto.view.in.InputReader;
import lotto.view.in.OrderInputDialog;
import lotto.view.in.SingleInputDialog;
import lotto.view.out.MessagePrinter;
import lotto.view.out.ResultViewer;
import lotto.view.out.WalletViewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {

	@DisplayName("수동구매없이 자동 10개 구입 테스트")
	@Test
	void investTest() {

		// Arrange
		LottoController controller = new LottoController(new TicketMachine());
		LottoOrder order = new LottoOrder(10000, null);
		OrderInputDialog orderDialog = new StaticOrderDialog(order);
		List<String> output = new ArrayList<>();

		// Action
		controller.invest(orderDialog, new WalletViewer(message -> output.add(message)));

		// Assertion
		assertThat(output).contains("10개를 구매했습니다.");

		Matcher m = Pattern.compile("(\\[.*?\\])").matcher(output.get(2)); // 0 : 공백, 1 : 제목
		int printedTicketPattern = 0;

		while (m.find()){
			printedTicketPattern++;
		}

		assertThat(printedTicketPattern).isEqualTo(10);
	}

	@DisplayName("자동구매 당첨확인 테스트")
	@Test
	void winTest(){
		// Arrange
		int[] manualNumbers = {1, 2, 3, 4, 5, 6};
		TicketMachine machine = new StaticTicketMachine(manualNumbers);
		LottoController controller = new LottoController(machine);
		LottoOrder order = new LottoOrder(1000, null);
		controller.invest(new StaticOrderDialog(order), new WalletViewer(message -> {}));
		List<String> output = new ArrayList<>();

		SingleInputDialog winNumberInput = message -> (message.contains("당첨 번호") ? "1, 2, 3, 10, 11, 12" : "45");

		// Action
		controller.lottery(winNumberInput, new ResultViewer(message -> output.add(message)));

		// Assertion
		assertThat(output).contains("당첨통계");
		assertThat(output).contains("3개 일치 (5000원)- 1개");
		assertThat(output).contains("총 수익률은 5.00입니다.");
	}

	/**
	 * 지정된 숫자로 복권을 발행하는 테스트용 클래스
	 */
	class StaticTicketMachine extends TicketMachine{

		private int[] numbers;

		public StaticTicketMachine(int[] numbers) {
			this.numbers = numbers;
		}

		@Override
		public LottoTicket issuingTicket(){
			return LottoTicket.of(numbers);
		}
	}

	/**
	 * 정해진 주문서를 반환하는 테스트용 클래스
	 */
	class StaticOrderDialog extends OrderInputDialog {

		private LottoOrder order;

		public StaticOrderDialog(LottoOrder order) {
			super(null, null);
			this.order = order;
		}

		@Override
		public LottoOrder makeOrder(){
			return order;
		}
	}
}
