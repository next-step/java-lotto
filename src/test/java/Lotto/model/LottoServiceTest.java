package Lotto.model;

import Lotto.model.NumberExtractor.FixedNumberExtractor;
import Lotto.model.NumberExtractor.NumberExtractor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
        final Map<LottoRank, Integer> expected = Map.of(
                LottoRank.MISS, 0,
                LottoRank.FIFTH, 14,
                LottoRank.FOURTH, 0,
                LottoRank.THIRD, 0,
                LottoRank.SECOND, 0,
                LottoRank.FIRST, 0
        );

        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(PURCHASE_AMOUNT, extractor);
        service.draw();
        service.decideWinning(List.of(1, 2, 3, 7, 8, 9), 10);
        assertThat(service.winningCountMap()).isEqualTo(expected);
        assertThat(service.profitRate()).isEqualTo(5);
    }

    @Test
    void shouldNotAllowPurchase_WhenPurchaseAmountIsUnder1000Won() {
        final int PURCHASE_AMOUNT = 900;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoService(PURCHASE_AMOUNT, extractor))
                .withMessage("The minimum of purchase price is 1,000 won.");
    }

    @Test
    void shouldNotAllowPurchase_WhenPurchaseAmountIsNotDivisibleBy1000() {
        final int PURCHASE_AMOUNT = 1001;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoService(PURCHASE_AMOUNT, extractor))
                .withMessage("The purchase price is in units of 1,000 won.");
    }

    @Test
    void shouldNotAllowWinningLottoNumber_WhenNumberCountExceed6() {
        final int PURCHASE_AMOUNT = 1000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(PURCHASE_AMOUNT, extractor);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.decideWinning(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .withMessage("The count of Lotto number exceed 6.");
    }

    @Test
    void shouldNotAllowWinningLottoNumber_WhenWinningNumberContainDuplicates() {
        final int PURCHASE_AMOUNT = 1000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(PURCHASE_AMOUNT, extractor);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.decideWinning(List.of(1, 2, 2, 4, 5, 6), 10))
                .withMessage("Lotto numbers must not contain duplicates.");
    }

    @Test
    void shouldBe2ndPlace(){
        final int PURCHASE_AMOUNT = 1000;
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        LottoService service = new LottoService(PURCHASE_AMOUNT, extractor);
        service.draw();
        service.decideWinning(List.of(1, 2, 3, 4, 5, 11), 6);
        assertThat(service.winningCountMap().get(LottoRank.SECOND)).isEqualTo(1);
    }
}
