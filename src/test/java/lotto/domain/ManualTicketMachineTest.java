package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualTicketMachineTest {

    private int manualCount;
    private LottoUserRequest lottoUserRequest;

    @BeforeEach
    void setUp() {
        String[] manualTicketNumbers = {"8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38",
              "7, 11, 16, 35, 36, 44"};

        this.manualCount = manualTicketNumbers.length;
        this.lottoUserRequest = new LottoUserRequest(3_000, manualTicketNumbers);
    }

    @DisplayName("처리할 대상 존재여부 확인")
    @Test
    void hasTarget() {
        //given
        ManualTicketMachine manualTicketMachine = new ManualTicketMachine();

        //when, then
        assertThat(manualTicketMachine.hasTarget(lottoUserRequest)).isTrue();
    }

    @DisplayName("로또티켓 수동 발행")
    @Test
    void issueTickets() {
        //given
        ManualTicketMachine ticketMachine = new ManualTicketMachine();

        //when
        List<LottoTicket> lottoTickets = ticketMachine.issue(lottoUserRequest);

        //then
        assertThat(lottoTickets.size()).isEqualTo(manualCount);
    }
}
