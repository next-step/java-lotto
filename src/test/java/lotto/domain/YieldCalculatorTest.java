package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.upCount(LottoDescription.findLottoHash(3, false));
        lottoResult.upCount(LottoDescription.findLottoHash(3, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(5, false));
    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResult, 1000)).isEqualTo(310.00);
    }
}