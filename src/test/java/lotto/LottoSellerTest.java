package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {
    LottoCount lottoCount3 = LottoCount.from(PurchaseAmount.from(3000));
    LottoSeller lottoSeller = LottoSeller.from(lottoCount3);

    @Test
    void generateLotto() {
        assertThat(lottoSeller.generateLotto())
                .isInstanceOf(Lotto.class)
                .extracting(Lotto::getLottoNumbers)
                .asList()
                .hasSize(6);
    }

    @Test
    void generateLottos() {
        assertThat(lottoSeller.generateLottos())
                .isInstanceOf(Lottos.class)
                .extracting(Lottos::getLottos)
                .asList()
                .hasSize(lottoCount3.getLottoCount());
    }
}
