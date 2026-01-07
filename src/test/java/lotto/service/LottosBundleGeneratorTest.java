package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosBundleGeneratorTest {
    
    @Test
    void 수동_로또와_자동_로또를_합쳐서_총_구매_개수가_맞는지_확인한다() {
        List<String> manualLottoText = List.of(
            "1, 2, 3, 4, 5, 6",
            "7, 8, 9, 10, 11, 12",
            "13, 14, 15, 16, 17, 18"
        );

        LottoPurchase purchase = new LottoPurchase(BigDecimal.valueOf(14000));

        LottosBundleGenerator generator = new LottosBundleGenerator(purchase, manualLottoText);
        Lottos result = generator.generate();

        assertThat(result.size()).isEqualTo(purchase.size());
    }
}
