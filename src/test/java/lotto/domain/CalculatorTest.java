package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private LottoResults lottoResults;
    private List<LottoResult> lottoResultGroup;

    @BeforeEach
    void setUp(){
        lottoResultGroup = Arrays.asList(
            new LottoResult(Rank.FIFTH, 1),
            new LottoResult(Rank.FOURTH, 0),
            new LottoResult(Rank.THIRD, 0),
            new LottoResult(Rank.SECOND, 0),
            new LottoResult(Rank.FIRST, 0)
        );
        lottoResults = new LottoResults(lottoResultGroup);
    }

    @Test
    public void 수익률_계산() {
        Calculator calculator = new Calculator(lottoResults, 10000);
        assertThat(calculator.getEarnRate()).isEqualTo(0.5F);
    }

    @Test
    public void 로또_결과_리스트() {
        Calculator calculator = new Calculator(lottoResults, 10000);
        assertThat(calculator.getLottoResults()).isEqualTo(lottoResultGroup);
    }
}
