package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.controllers.EndController;
import lotto.controllers.WinningTicketController;

public class LottoTest {

	private static final int amount = 12;
	Purchase purchase = new Purchase("12345");
	List<Ticket> tickets = Arrays.asList(
		new Ticket("1,2,3,4,5,6"),
		new Ticket("1,2,3,4,5,6"),
		new Ticket("1,2,3,4,5,11"),
		new Ticket("1,2,3,4,10,11")
	);
	Ticket winningTicket = new Ticket("1,2,3,4,5,6");

	Model model = new Model();
	Lotto lotto = new Lotto(model);

	@DisplayName("로또 시작")
	@Test
	void start() {
		assertThat(lotto.isRunning()).isTrue();
	}

	@DisplayName("로또 종료")
	@Test
	void end() {
		lotto.toEndController();
		assertThat(lotto.isRunning()).isFalse();
	}

	@DisplayName("로또 자동 뽑기 후 다음 단계로 넘어간다.")
	@Test
	void automaticTicketing() {
		lotto.storage().savePurchase(purchase);

		lotto.toAutomaticTicketingController();
		lotto.run();

		assertThat(lotto.storage().loadAutomatedTickets().size()).isEqualTo(amount);
		assertThat(lotto.compareController(WinningTicketController.class)).isTrue();
	}

	@DisplayName("당첨 결과 발표 후 종료한다.")
	@Test
	void automatic() {
		lotto.storage().savePurchase(purchase);
		lotto.storage().saveAutomatedTickets(tickets);
		lotto.storage().saveWinningTicket(winningTicket);

		lotto.toResultController();
		lotto.run();

		assertThat(lotto.compareController(EndController.class)).isTrue();
		assertThat(lotto.isRunning()).isFalse();
	}

}
