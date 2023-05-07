package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Iterator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class PurchaseAutoTest {

    @Test
    void 자동_구매() {
        PurchaseStrategy strategy = PurchaseAuto.instance();
        Lotto actual = strategy.purchase();
        Iterator<LottoNumber> iterator = actual.numbers().iterator();
        assertAll(
            () -> assertThat(actual.numbers()).hasSize(Lotto.LOTTO_NUMBER_COUNT),
            () -> assertThat(actual.numbers()).isSubsetOf(PurchaseAuto.LOTTO_NUMBER_LIST),
            () -> {
                LottoNumber prev = null;
                while (iterator.hasNext()) {
                    LottoNumber current = iterator.next();
                    if (prev == null) {
                        prev = current;
                        continue;
                    }
                    assertThat(prev.value() < current.value()).isTrue();
                    prev = current;
                }
            }
        );
    }

}