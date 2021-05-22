package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.Model;
import lotto.Purchase;

public class AutomaticTicketingControllerTest {

    private static final int amount = 12;
    Purchase purchase = new Purchase("12345");

    Model model = new Model();
    Lotto lotto = new Lotto(model);

    AutomaticTicketingController automaticTicketingController;

    @BeforeEach
    void setUp() {
        lotto.storage().savePurchase(purchase);
        automaticTicketingController = new AutomaticTicketingController(lotto);
    }

    @DisplayName("티켓 수 불러오기")
    @Test
    void loadTotalTickets() {
        assertThat(automaticTicketingController.loadTotalTickets()).isEqualTo(amount);
    }

    @DisplayName("자동 티켓 불러오기")
    @Test
    void loadNewTickets() {
        assertThat(automaticTicketingController.loadNewTickets(amount).size()).isEqualTo(amount);
    }

    @DisplayName("다음 컨트롤러로 변경한다.")
    @Test
    void toNextController() {
        automaticTicketingController.toNextController();
        assertThat(lotto.compareController(WinningTicketController.class)).isTrue();
    }

}
