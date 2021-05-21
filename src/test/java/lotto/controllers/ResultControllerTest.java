package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.Model;
import lotto.Purchase;
import lotto.Ticket;

public class ResultControllerTest {

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

	ResultController resultController;

	@BeforeEach
	void setUp() {
		lotto.storage().savePurchase(purchase);
		lotto.storage().saveAutomatedTickets(tickets);
		lotto.storage().saveWinningTicket(winningTicket);

		resultController = new ResultController(lotto);
	}

	@DisplayName("당첨 번호 불러오기")
	@Test
	void loadWinningTicket() {
		assertThat(resultController.loadWinningTicket().toString()).isEqualTo(winningTicket.toString());
	}

	@DisplayName("티켓 불러오기")
	@Test
	void loadTickets() {
		assertThat(resultController.loadTickets().size()).isEqualTo(tickets.size());
	}

	@DisplayName("구입 금액 불러오기")
	@Test
	void loadPayment() {
		assertThat(resultController.loadPayment()).isEqualTo(12000);
	}

	@DisplayName("다음 컨트롤러로 변경한다.")
	@Test
	void toNextController() {
		resultController.toNextController();
		assertThat(lotto.compareController(EndController.class)).isTrue();
	}
}
