package domain.lotto;

import domain.common.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoPriceTest {


    @DisplayName("구매할 수 있는 로또 갯수를 반환한다.")
    @Test
    void availableForPurchase() {
        Assertions.assertThat(LottoPrice.availableForPurchase(new Money(1000L))).isEqualTo(1L);
    }
}
