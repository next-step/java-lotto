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

	private static final String cash = "12345";
	private static final int amount = 12;

	List<Ticket> tickets;
	Ticket winningTicket;

	Model model;
	Lotto lotto;

	ResultController resultController;

	@BeforeEach
	void setUp() {
		Purchase purchase = new Purchase(cash);
		this.winningTicket = new Ticket("1,2,3,4,5,6");
		this.tickets = Arrays.asList(
			new Ticket("1,2,3,4,5,6"),
			new Ticket("1,2,3,4,5,6"),
			new Ticket("1,2,3,4,5,11"),
			new Ticket("1,2,3,4,10,11")
		);

		this.model = new Model();
		this.model.savePurchase(purchase);
		this.model.saveAutomatedTickets(this.tickets);
		this.model.saveWinningTicket(this.winningTicket);
		this.lotto = new Lotto(model);
		this.resultController = new ResultController(this.lotto);
	}

	@DisplayName("당첨 번호 불러오기")
	@Test
	void loadWinningTicket() {
		assertThat(resultController.loadWinningTicket().toString()).isEqualTo(this.winningTicket.toString());
	}

	@DisplayName("티켓 불러오기")
	@Test
	void loadTickets() {
		assertThat(resultController.loadTickets().size()).isEqualTo(this.tickets.size());
	}

	@DisplayName("구입 금액 불러오기")
	@Test
	void loadPayment() {
		assertThat(resultController.loadPayment()).isEqualTo(amount * 1000);
	}

	@DisplayName("다음 컨트롤러로 변경한다.")
	@Test
	void toNextController() {
		resultController.toNextController();
		assertThat(lotto.compareController(EndController.class)).isTrue();
	}
}
