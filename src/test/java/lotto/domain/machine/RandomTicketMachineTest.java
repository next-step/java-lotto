package lotto.domain.machine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTicketMachineTest {

    private int money;
    private int manualCount;
    private LottoUserRequest lottoUserRequest;

    @BeforeEach
    void setUp() {
        List<String> manualTicketNumbers = Arrays
              .asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38",
                    "7, 11, 16, 35, 36, 44");

        this.money = 4_000;
        this.manualCount = manualTicketNumbers.size();
        this.lottoUserRequest = new LottoUserRequest(money, manualTicketNumbers);
    }

    @DisplayName("처리할 대상 존재여부 확인")
    @Test
    void hasTarget() {
        //given
        RandomTicketMachine ticketMachine = new RandomTicketMachine();

        //when, then
        assertThat(ticketMachine.hasTarget(lottoUserRequest)).isTrue();
    }

    @DisplayName("로또티켓 자동 발행")
    @Test
    void issueTickets() {
        //given
        RandomTicketMachine ticketMachine = new RandomTicketMachine();

        //when
        List<LottoTicket> lottoTickets = ticketMachine.issue(lottoUserRequest);

        //then
        assertThat(lottoTickets.size()).isEqualTo(money / 1_000 - manualCount);
    }
}
