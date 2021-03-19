package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 발급 기계")
public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"11000,11", "1000,1"})
    @DisplayName("로또 금액 대비 개수 확인")
    public void inputLottoAmount(int amount, int ticketCount) throws Exception {

        //given
        LottoQuantity lottoQuantity = new LottoQuantity(amount);

        //when

        //then
        assertThat(lottoQuantity.lottoQuantity()).isEqualTo(ticketCount);
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
