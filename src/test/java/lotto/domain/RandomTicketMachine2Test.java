package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTicketMachine2Test {

    private int money;
    private int manualCount;
    private LottoUserRequest lottoUserRequest;

    @BeforeEach
    void setUp() {
        String[] manualTicketNumbers = {"8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38",
              "7, 11, 16, 35, 36, 44"};

        this.money = 4_000;
        this.manualCount = manualTicketNumbers.length;
        this.lottoUserRequest = new LottoUserRequest(money, manualTicketNumbers);
    }

    @DisplayName("처리할 대상 존재여부 확인")
    @Test
    void hasTarget() {
        //given
        RandomTicketMachine2 randomTicketMachine2 = new RandomTicketMachine2();

        //when, then
        assertThat(randomTicketMachine2.hasTarget(lottoUserRequest)).isTrue();
    }

    @DisplayName("로또티켓 자동 발행")
    @Test
    void issueTickets() {
        //given
        RandomTicketMachine2 ticketMachine = new RandomTicketMachine2();

        //when
        List<LottoTicket> lottoTickets = ticketMachine.issue(lottoUserRequest);

        //then
        assertThat(lottoTickets.size()).isEqualTo(money / 1_000 - manualCount);
    }
}
