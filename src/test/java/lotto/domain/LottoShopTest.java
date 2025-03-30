package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoShopTest {

    private LottoShop lottoShop = new LottoShop();

    @Test
    void 구입금액보다_수동구입금액이_크면_throw한다() {
        List<List<Integer>> lottoManualNumbers = List.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6));

        IllegalArgumentException e = catchIllegalArgumentException(
                () -> lottoShop.purchase(new Money(1000), lottoManualNumbers));

        assertThat(e).hasMessage("구입금액보다 수동구입금액이 큽니다.");
    }

    @Test
    void lotto_수량_테스트() {
        List<List<Integer>> lottoManualNumbers = List.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12));

        LottoPurchase purchase = lottoShop.purchase(new Money(10031), lottoManualNumbers);

        assertThat(purchase.getAutoSize()).isEqualTo(8);
        assertThat(purchase.getManualSize()).isEqualTo(2);
        assertThat(purchase.getLottos()).hasSize(purchase.getAutoSize() + purchase.getManualSize());
    }

}
