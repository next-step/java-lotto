package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.Model;
import lotto.Purchase;

public class AutomaticTicketingControllerTest {

	private static final String cash = "12345";
	private static final int amount = 12;

	Model model;
	Lotto lotto;

	AutomaticTicketingController automaticTicketingController;

	@BeforeEach
	void setUp() {
		Purchase purchase = new Purchase(cash);
		this.model = new Model();
		this.model.savePurchase(purchase);
		this.lotto = new Lotto(model);
		this.automaticTicketingController = new AutomaticTicketingController(this.lotto);
	}

	@DisplayName("티켓 수 불러오기")
	@Test
	void totalTickets() {
		assertThat(automaticTicketingController.totalTickets()).isEqualTo(amount);
	}

	@DisplayName("자동 티켓 생성")
	@Test
	void newTickets() {
		assertThat(automaticTicketingController.newTickets(amount).size()).isEqualTo(amount);
	}

	@DisplayName("다음 컨트롤러로 변경한다.")
	@Test
	void toNextController() {
		automaticTicketingController.toNextController();
		assertThat(lotto.compareController(EndController.class)).isTrue();
	}

}
