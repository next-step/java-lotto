package lotto;

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
		LottoController controller = new LottoController();
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
}
