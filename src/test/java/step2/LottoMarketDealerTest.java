package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMarketDealerTest {

    @Test
    public void 구매() {
        LottoNumbers manualNumber1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        LottoNumbers manualNumber2 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        LottoPurchaseRequest request = new LottoPurchaseRequest(Money.of(14000), manualNumber1, manualNumber2);
        Lottos lottos = LottoMarketDealer.purchase(request);
        assertThat(lottos.getCount()).isEqualTo(14);
    }

    @Test
    public void 구매_실패() {
        LottoNumbers manualNumber1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        assertThatThrownBy(() -> {
            LottoPurchaseRequest request = new LottoPurchaseRequest(Money.of(0), manualNumber1);
            Lottos lottos = LottoMarketDealer.purchase(request);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
