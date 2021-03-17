package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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
        Assertions.assertThat(tickets.size()).isEqualTo(ticketCount);
    }
}
