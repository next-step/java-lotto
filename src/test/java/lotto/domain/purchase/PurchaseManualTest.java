package lotto.domain.purchase;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class PurchaseManualTest {

    @Test
    void 수동_구매() {
        PurchaseStrategy strategy = PurchaseManual.instance();
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes(StandardCharsets.UTF_8)));

        assertThat(strategy.purchase())
            .isEqualTo(new Lotto(List.of(LottoNumber.of(1)
                , LottoNumber.of(2)
                , LottoNumber.of(3)
                , LottoNumber.of(4)
                , LottoNumber.of(5)
                , LottoNumber.of(6))));

    }

}