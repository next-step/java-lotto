package Lotto.model;

import Lotto.model.NumberExtractor.FixedNumberExtractor;
import Lotto.model.NumberExtractor.NumberExtractor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    @Test
    void shouldBe14Lotto() {
        final int purchaseAmount = 14000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(purchaseAmount, extractor);
        assertThat(service.lottoNum()).isEqualTo(14);
    }

    @Test
    void countMatchNum() {
        final int purchaseAmount = 14000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(purchaseAmount, extractor);
        service.draw();
        service.decideWinning(new int[]{1, 2, 3, 7, 8, 9});
        assertThat(service.winningCounts()).containsExactly(new int[]{14, 0, 0, 0});
        assertThat(service.profitRate()).isEqualTo(5);
    }
}
