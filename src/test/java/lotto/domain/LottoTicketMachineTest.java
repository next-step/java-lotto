package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketMachineTest {

    private LottoTicketMachine lottoTicketMachine;

    @BeforeEach
    void init() {
        lottoTicketMachine = new LottoTicketMachine();
    }

    @Test
    void createLottoNumbers() throws Exception {
        //given
        int purchaseAmount = 14000;

        //when
        lottoTicketMachine.createLottoNumbers(purchaseAmount);

        //then
        assertThat(lottoTicketMachine.getLottoCount()).isEqualTo(14);
    }

    @Test
    void calculateLottoStatistics() throws Exception {
        //given
        lottoTicketMachine.createLottoNumbers(14000);
        WinningTicket winningTicket = new WinningTicket(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                new LottoNumber(7)
        );

        //when

        //then
        assertDoesNotThrow(() -> lottoTicketMachine.calculateLottoStatistics(winningTicket));
    }
}
