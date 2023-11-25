package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoCountSummary;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {
    @Test
    void generateLottos() {
        int autoLottoCount = 2;
        LottoSeller lottoSeller = LottoSeller.from(LottoCountSummary.of(1, autoLottoCount));
        assertThat(lottoSeller.generateAutoLottos())
                .isInstanceOf(Lottos.class)
                .extracting(Lottos::getLottos)
                .asList()
                .hasSize(autoLottoCount);
    }
}
