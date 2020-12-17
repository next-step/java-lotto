package lotto.domain.machine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComplexTicketMachineTest {

    @DisplayName("복합 티켓 생성 - 자동티켓만 있는 경우")
    @Test
    void issue_auto() {
        //given
        int money = 5_000;
        ComplexTicketMachine complexTicketMachine = new ComplexTicketMachine(
              new RandomTicketMachine(), new ManualTicketMachine());
        LottoUserRequest lottoUserRequest = new LottoUserRequest(money);

        //when
        List<LottoTicket> lottoTickets = complexTicketMachine.issue(lottoUserRequest);

        //then
        assertThat(lottoTickets.size()).isEqualTo(money / 1_000);
    }

    @DisplayName("복합 티켓 생성 - 동티켓만 있는 경우")
    @Test
    void issue_manual() {
        //given
        int money = 3_000;
        List<String> manualTicketNumbers = Arrays
              .asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38",
                    "7, 11, 16, 35, 36, 44");
        LottoUserRequest lottoUserRequest = new LottoUserRequest(money, manualTicketNumbers);
        ComplexTicketMachine complexTicketMachine = new ComplexTicketMachine(
              new RandomTicketMachine(), new ManualTicketMachine());

        //when
        List<LottoTicket> lottoTickets = complexTicketMachine.issue(lottoUserRequest);

        //then
        List<LottoTicket> expected = manualTicketNumbers.stream().map(LottoTicket::new)
              .collect(Collectors.toList());

        assertThat(lottoTickets.size()).isEqualTo(money / 1_000);
        assertThat(lottoTickets).isEqualTo(expected);
    }
}
