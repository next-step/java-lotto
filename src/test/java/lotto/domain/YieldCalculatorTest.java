package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    LottoResult lottoResult;
    Money money;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.upCount(LottoDescription.findLottoHash(3, false));
        lottoResult.upCount(LottoDescription.findLottoHash(3, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(5, false));
        money = new Money("1000");
    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResult, money)).isEqualTo(310.00);
    }
}
