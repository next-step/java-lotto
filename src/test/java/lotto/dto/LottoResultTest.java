package lotto.dto;

import lotto.domain.CalculatePrize;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("Lotto 결과 계산 테스트")
    void crateResult() {
        LottoResult lottoResult = new LottoResult(1);
        lottoResult.add(CalculatePrize.FIRST);
        lottoResult.calculatePrizeCount();
        assertThat(lottoResult.getFirst()).isEqualTo(1);
    }

    @Test
    @DisplayName("Lotto 결과 여러개 계산 테스트")
    void calculateLotto() {
        LottoResult lottoResult = new LottoResult(5);

        for (CalculatePrize value : CalculatePrize.values()) {
            lottoResult.add(value);
        }

        lottoResult.calculatePrizeCount();
        assertThat(lottoResult.getFirst()).isEqualTo(1);
        assertThat(lottoResult.getSecond()).isEqualTo(1);
        assertThat(lottoResult.getThird()).isEqualTo(1);
        assertThat(lottoResult.getFourth()).isEqualTo(1);
        assertThat(lottoResult.getFifth()).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateYield() {
        LottoResult lottoResult = new LottoResult(5);
        //5개 구매 -> 5등 한개일 경우 수익률 1
        lottoResult.add(CalculatePrize.FIFTH);
        lottoResult.calculatePrizeCount();
        assertThat(lottoResult.getYield()).isEqualTo(new BigDecimal(1).setScale(2, RoundingMode.UP));
    }
}