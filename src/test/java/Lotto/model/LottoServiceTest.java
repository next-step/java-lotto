package Lotto.model;

import Lotto.model.NumberExtractor.FixedNumberExtractor;
import Lotto.model.NumberExtractor.NumberExtractor;
import Lotto.model.NumberExtractor.RandomNumberExtractor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoServiceTest {
    @Test
    void shouldBe14Lotto() {
        final int PURCHASE_AMOUNT = 14000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(PURCHASE_AMOUNT, extractor);
        assertThat(service.lottoNum()).isEqualTo(14);
    }

    @Test
    void countMatchNum() {
        final int PURCHASE_AMOUNT = 14000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(PURCHASE_AMOUNT, extractor);
        service.draw();
        service.decideWinning(new int[]{1, 2, 3, 7, 8, 9});
        assertThat(service.winningCounts()).containsExactly(new int[]{14, 0, 0, 0});
        assertThat(service.profitRate()).isEqualTo(5);
    }

    @Test
    void shouldNotAllowPurchase_WhenPurchaseAmountIsUnder1000Won(){
        final int PURCHASE_AMOUNT = 900;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        assertThatIllegalArgumentException()
                .isThrownBy(()->new LottoService(PURCHASE_AMOUNT, extractor))
                .withMessage("The minimum of purchase price is 1,000 won.");
    }

    @Test
    void shouldNotAllowPurchase_WhenPurchaseAmountIsNotDivisibleBy1000(){
        final int PURCHASE_AMOUNT = 1001;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        assertThatIllegalArgumentException()
                .isThrownBy(()->new LottoService(PURCHASE_AMOUNT, extractor))
                .withMessage("The purchase price is in units of 1,000 won.");
    }
}
