package lotto;

import lotto.model.LottoPrice;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoPriceTest {
    @Test
    public void 가진_금액_보다_구입_개수가_많은_경우() {
        assertThatIllegalArgumentException().isThrownBy(() ->  new LottoPrice(14000, "15"));
    }

    @Test
    public void 정상_구입() {
        LottoPrice lottoPrice = new LottoPrice(14000,"3");
        assertThat(lottoPrice.manualPrice()).isEqualTo(3 * Lotto.PRICE);
        assertThat(lottoPrice.autoPrice()).isEqualTo(11 * Lotto.PRICE);
    }

}
