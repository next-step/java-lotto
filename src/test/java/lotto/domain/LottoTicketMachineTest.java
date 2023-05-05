package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketMachineTest {

    private LottoTicketMachine lottoTicketMachine;

    @BeforeEach
    void init() {
        lottoTicketMachine = new LottoTicketMachine();
    }

    @Test
    void calculateLottoStatistics() throws Exception {
        //given
        lottoTicketMachine.createAutoLottoTickets(14000);
        WinningTicket winningTicket = new WinningTicket(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                LottoNumber.of(7)
        );

        //when

        //then
        assertDoesNotThrow(() -> lottoTicketMachine.calculateLottoStatistics(winningTicket));
    }
}
