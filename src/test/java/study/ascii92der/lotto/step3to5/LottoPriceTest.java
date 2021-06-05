package study.ascii92der.lotto.step3to5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPriceTest {

    @Test
    @DisplayName("입력된 액수만큼 구매할 수 있는 로또 수 테스트")
    void buyLottoCount() {
        LottoPrice lottoPrice = new LottoPrice(14000);

        assertThat(lottoPrice.lottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("invalid money test")
    void invalidMoneyTest() {

        assertThatThrownBy(() -> new LottoPrice(-14000)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoPrice.ERROR_MASSAGE_NOT_ENOUGH_INPUT_MONEY);
    }

    @Test
    @DisplayName("로또 차액 구하기")
    void differenceLottoPrice() {
        LottoPrice lottoPrice = new LottoPrice(15000);
        assertThat(lottoPrice.differenceLottoPrice(10)).isEqualTo(new LottoPrice(5000));
    }
}
