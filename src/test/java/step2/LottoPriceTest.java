package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPriceTest {
    @Test
    @DisplayName("갯수당 총 가격 테스트")
    void getQuoteTest() {
        LottoPrice lottoPrice = new LottoPrice(1000);

        assertThat(lottoPrice.getQuote(0)).isEqualTo(0);

        LottoPrice lottoPrice2 = new LottoPrice(1000);

        assertThat(lottoPrice2.getQuote(1)).isEqualTo(1000);

        LottoPrice lottoPrice3 = new LottoPrice(1000);

        assertThat(lottoPrice3.getQuote(2)).isEqualTo(2000);
    }

    @Test
    @DisplayName("예산으로 가능한 갯수 계산 테스트")
    void getMaxQuantityTest() {
        LottoPrice lottoPrice = new LottoPrice(1000);

        assertThat(lottoPrice.getMaxQuantity(900)).isEqualTo(0);

        LottoPrice lottoPrice2 = new LottoPrice(1000);

        assertThat(lottoPrice2.getMaxQuantity(1100)).isEqualTo(1);

        LottoPrice lottoPrice3 = new LottoPrice(1000);

        assertThat(lottoPrice3.getMaxQuantity(2000)).isEqualTo(2);
    }
}
