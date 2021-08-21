package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.Prize;
import edu.nextstep.lottobonusnumber.domain.Ticket;
import edu.nextstep.lottobonusnumber.domain.TicketMachine;
import edu.nextstep.lottobonusnumber.domain.WinningCheckMachine;
import edu.nextstep.lottobonusnumber.view.form.WinningResultForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckMachineTest {

    @ParameterizedTest(name = "당첨 결과 확인 {0}등")
    @CsvSource({"2,7,FIRST", "1,6,SECOND", "3,8,THIRD", "4,9,FOURTH", "5,10,FIFTH", "6,11,LOSE"})
    void checkWinningResult(int numFrom, int numTo, Prize winningPrize) {
        // given
        int payment = TicketMachine.TICKET_PRICE;
        List<Ticket> tickets = TicketMachine.createTickets(payment, () -> createNumbersFromTo(numFrom,numTo));
        String winningNumbersString = "2, 3, 4, 5, 6, 7";
        int bonusNumber = 1;
        WinningTicket winningTicket = WinningTicket.of(winningNumbersString, bonusNumber);

        // when
        WinningResultForm winningResult =
                WinningCheckMachine.confirmWinningResult(tickets,winningTicket);
        double checkRateOfReturn = (double) winningPrize.getWinningPrize() / payment;

        // then
        assertThat(winningResult.getWinningResult().getOrDefault(winningPrize,0)).isEqualTo(1);
        assertThat(winningResult.getRateOfReturn()).isEqualTo(checkRateOfReturn);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}