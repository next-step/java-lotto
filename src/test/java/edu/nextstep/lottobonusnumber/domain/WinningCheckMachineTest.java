package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.Prize;
import edu.nextstep.lottobonusnumber.domain.Ticket;
import edu.nextstep.lottobonusnumber.domain.TicketMachine;
import edu.nextstep.lottobonusnumber.domain.WinningCheckMachine;
import edu.nextstep.lottobonusnumber.view.form.WinningResultForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckMachineTest {

    @Test
    @DisplayName("당첨 결과 확인 ")
    void checkWinningResult() {
        // given
        List<Ticket> tickets = TicketMachine.createTickets(1000, () -> createNumbersFromTo(1,6));
        String winningNumbersString = "4,5,6,7,8,9";
        int bonusNumber = 10;
        WinningTicket winningTicket = WinningTicket.of(winningNumbersString, bonusNumber);

        // when
        WinningResultForm winningResult =
                WinningCheckMachine.confirmWinningResult(tickets,winningTicket);

        // then
        assertThat(winningResult.getWinningResult().getOrDefault(Prize.FIFTH,0)).isEqualTo(1);
        assertThat(winningResult.getRateOfReturn()).isEqualTo(5);
    }

    @Test
    @DisplayName("2등 당첨 결과 확인 : 보너스 번호")
    void checkWinningResult_SECOND() {
        // given
        List<Ticket> tickets = TicketMachine.createTickets(1000, () -> createNumbersFromTo(5,10));
        String winningNumbersString = "4,5,6,7,8,9";
        int bonusNumber = 10;
        WinningTicket winningTicket = WinningTicket.of(winningNumbersString, bonusNumber);

        // when
        WinningResultForm winningResult =
                WinningCheckMachine.confirmWinningResult(tickets,winningTicket);

        // then
        assertThat(winningResult.getWinningResult().getOrDefault(Prize.SECOND,0)).isEqualTo(1);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}