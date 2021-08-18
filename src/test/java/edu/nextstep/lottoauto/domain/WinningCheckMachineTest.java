package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.view.form.WinningResultForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckMachineTest {

    @BeforeEach
    void removeAll(){
        TicketRepository.removeAll();
    }

    @Test
    @DisplayName("당첨 결과 확인")
    void checkWinningResult() {
        // given
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.createAndSaveTickets(1000, () -> createNumbersFromTo(1,6));

        // when
        WinningCheckMachine winningCheckMachine = new WinningCheckMachine();
        WinningResultForm winningResult =
                winningCheckMachine.confirmWinningResult("4,5,6,7,8,9");

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