package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"11000,11", "1000,1"})
    @DisplayName("로또 구매 개수 확인")
    public void inputLottoAmount(int amount, int ticketCount ) throws Exception {

        //given
        LottoMachine lottoMachine = new LottoMachine(amount);

        //when
        List<LottoTicket> tickets = lottoMachine.getLottoTickets();

        //then
        assertThat(tickets.size()).isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("로또 구매금액 천원미만 유효성 확인")
    public void zeroAmountExceptionTest() throws Exception {
        //given
        int amount = 0;

        //when, then
        assertThatThrownBy(() -> new LottoMachine(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
