package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.view.form.WinningResultForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckMachineTest {

    @Test
    @DisplayName("당첨 결과 확인")
    void checkWinningResult() {
        // given
        List<Ticket> tickets = TicketMachine.createTickets(1000, () -> createNumbersFromTo(1,6));

        // when
        WinningResultForm winningResult =
                WinningCheckMachine.confirmWinningResult(tickets,"4,5,6,7,8,9");

        // then
        assertThat(winningResult.getWinningResult().getOrDefault(Prize.FOURTH,0)).isEqualTo(1);
        assertThat(winningResult.getRateOfReturn()).isEqualTo(5);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}