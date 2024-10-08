package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 로또_한개만_구매() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int purchasePrice = 1000;
        List<Lotto> lotto = lottoGenerator.purchaseLotto(purchasePrice);
        assertThat(lotto.size()).isEqualTo(1);
    }

    @Test
    void 로또_여러개_구매() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int purchasePrice = 7000;
        List<Lotto> lotto = lottoGenerator.purchaseLotto(purchasePrice);
        assertThat(lotto.size()).isEqualTo(7);
    }
}