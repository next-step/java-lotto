package lotto.domain;

import lotto.exception.InvalidBudgetException;
import lotto.exception.InvalidManualLottoCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoPriceTests {

    @DisplayName("money 생성 테스트")
    @Test
    void create(){
        LottoPrice lottoPrice = LottoPrice.of(14000);

        assertThat(lottoPrice).isEqualTo(LottoPrice.of(14000));
    }

    @DisplayName("돈을 잘못 입력 했을 때 exception 테스트")
    @Test
    void InvalidBudgetExceptionTest() {

        assertThatExceptionOfType(InvalidBudgetException.class)
                .isThrownBy(() -> {
                    LottoPrice lottoPrice = LottoPrice.of(0);
                }).withMessageMatching("돈을 잘못 입력 하였습니다.");
    }

    @DisplayName("수동 로또 구입 금액이 총 금액보다 많을 때 exception 테스트")
    @Test
    void InvalidManualLottoCountExceptionTest() {
        LottoPrice lottoPrice = LottoPrice.of(14000);
        assertThatExceptionOfType(InvalidManualLottoCountException.class)
                .isThrownBy(() -> {
                    lottoPrice.checkOverPrice(15);
                }).withMessageMatching("수동 로또 구입 금액이 총 금액보다 많습니다.");
    }

    @DisplayName("금액에 대한 티켓 갯수 테스트")
    @Test
    void getMaxQuantityTest(){
        LottoPrice lottoPrice = LottoPrice.of(14000);

        assertThat(lottoPrice.getMaxQuantity()).isEqualTo(14);
    }

    @DisplayName("총 상금을 전달 했을때 비율 테스트")
    @Test
    void getRatioTest(){
        LottoPrice lottoPrice = LottoPrice.of(14000);

        assertThat(lottoPrice.getRatio(5000)).isEqualTo(0.35714285714285715);
    }


}
