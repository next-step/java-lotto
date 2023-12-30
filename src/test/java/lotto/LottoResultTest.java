package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoResult;

class LottoResultTest {

    @Test
    @DisplayName("수익률을 정확히 계산하는지 확인한다.")
    void test1() {
        int totalPriceToBuyLotto = 1000;
        LottoResult lottoResult = new LottoResult(Map.of(6, 1));
        float expectingResult = 2000000;

        assertThat(lottoResult.calculateRateOfReturn(totalPriceToBuyLotto)).isEqualTo(expectingResult);
    }
}

