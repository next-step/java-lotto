package lotto;

import lotto.domain.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("로또 구매 개수 확인")
    public void inputLottoAmount() throws Exception {
        //given
        int amount = 11000;
        int ticketQuantity = lottoMachine.amountToQuantity(amount);
        //when

        //then
        Assertions.assertThat(ticketQuantity).isEqualTo(11);
    }
}
