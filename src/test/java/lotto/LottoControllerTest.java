package lotto;

import lotto.view.out.ResultViewer;
import lotto.view.out.WalletViewer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {

	@Test
	void investTest() {

		// Arrange
		LottoController controller = new LottoController(new TicketMachine());
		List<String> output = new ArrayList<>();

		// Action
		controller.invest(message -> "10000", new WalletViewer(message -> output.add(message)));

		// Assertion
		assertThat(output).contains("10개를 구매했습니다.");

		Matcher m = Pattern.compile("(\\[.*?\\])").matcher(output.get(1));
		int printedTicketPattern = 0;

		while (m.find()){
			printedTicketPattern++;
		}

		assertThat(printedTicketPattern).isEqualTo(10);
	}

	@Test
	void winTest(){
		// Arrange
		int[] manualNumbers = {1, 2, 3, 4, 5, 6};
		TicketMachine machine = new StaticTicketMachine(manualNumbers);
		LottoController controller = new LottoController(machine);
		List<String> output = new ArrayList<>();
		controller.invest(message -> "1000", new WalletViewer(message -> {}));

		// Action
		controller.lottery(message -> "1, 2, 3, 10, 11, 12", new ResultViewer(message -> output.add(message)));

		// Assertion
		assertThat(output).contains("당첨통계");
	}

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
}
