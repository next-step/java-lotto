package lotto;

import lotto.view.out.WalletViewer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {

	@Test
	void investTest() {

		LottoController controller = new LottoController();
		List<String> output = new ArrayList<>();
		controller.invest(message -> "10000", new WalletViewer(message -> output.add(message)));

		assertThat(output).contains("10개를 구매했습니다.");
	}
}
