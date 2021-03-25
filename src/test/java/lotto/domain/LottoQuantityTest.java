package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 가격")
class LottoQuantityTest {

    @ParameterizedTest
    @CsvSource(value = {"11000,11", "1000,1"})
    @DisplayName("자동 로또 개수 확인")
    void autoLottoSizeTest(int amount, int ticketCount) {
        //given
        LottoQuantity lottoQuantity = new LottoQuantity(amount);

        //when

        //then
        assertThat(lottoQuantity.isUnderAutoQuantity(ticketCount)).isTrue();
        assertThat(lottoQuantity.isUnderAutoQuantity(ticketCount+1)).isFalse();
    }

    @Test
    @DisplayName("로또 구매금액 천원미만 유효성 확인")
    void zeroAmountExceptionTest() {
        //given
        int amount = 0;

        //when, then
        assertThatThrownBy(() -> new LottoQuantity(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000,5,5,5", "10000,10,0,10"})
    @DisplayName("수동 개수 존재 시 오토 개수 확인")
    void manualQuantityTest(int buyAmount, int manualQuantity, int autoCheck) {
        //given
        LottoQuantity lottoQuantity = new LottoQuantity(buyAmount, manualQuantity);

        //when

        //then
        assertThat(lottoQuantity.isUnderAutoQuantity(autoCheck)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"10000,11"})
    @DisplayName("수동 개수가 금액초과 시 예외 확인")
    void manualOverQuantityExceptionTest(int buyAmount, int manualQuantity) {
        //given

        //when
        assertThatThrownBy(() -> new LottoQuantity(buyAmount, manualQuantity))
                .isInstanceOf(IllegalArgumentException.class);

        //then
    }
}
