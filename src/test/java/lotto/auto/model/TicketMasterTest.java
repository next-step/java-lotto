package lotto.auto.model;

import lotto.auto.strategy.AutoLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class TicketMasterTest {
    private TicketMaster ticketMaster;

    @BeforeEach
    void init() {
        ticketMaster = TicketMaster.init(AutoLotto.init());
    }

    @Test
    @DisplayName("천원 이상의 값을 입력하면 게임을 생성한다. 천원당 한 게임이다")
    void ticketing() {
        List<LottoGame> ticketing = ticketMaster.ticketing(1000);
        Assertions.assertThat(ticketing.size()).isEqualTo(1);

        ticketing = ticketMaster.ticketing(2500);
        Assertions.assertThat(ticketing.size()).isEqualTo(2);

        ticketing = ticketMaster.ticketing(15500);
        Assertions.assertThat(ticketing.size()).isEqualTo(15);
    }

    @Test
    @DisplayName("천원 미만의 값을 입력하면 예외를 발생시킨다")
    void ticketingException() {
        Assertions.assertThatThrownBy(() -> ticketMaster.ticketing(999))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("don't have enough money.");
    }
}
