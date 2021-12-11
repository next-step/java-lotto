package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private List<LottoResult> lottoResults;

    @BeforeEach
    void setUp(){
        lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(Rank.valueOf(3), 1));
        lottoResults.add(new LottoResult(Rank.valueOf(4), 0));
        lottoResults.add(new LottoResult(Rank.valueOf(5), 0));
        lottoResults.add(new LottoResult(Rank.valueOf(6), 0));
    }

    @Test
    public void 수익률계산() {
        Calculator calculator = new Calculator(lottoResults, 10000);
        assertThat(calculator.getEarnRate()).isEqualTo(0.5F);
    }

    @Test
    public void 로또_결과_리스트() {
        Calculator calculator = new Calculator(lottoResults, 10000);
        assertThat(calculator.getLottoResults()).isEqualTo(lottoResults);
    }
}
