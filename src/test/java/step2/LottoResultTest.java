package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoResult;
import step2.domain.LottoTier;
import step2.domain.Money;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        Map<LottoTier, Integer> resultMap = new HashMap<>();

        resultMap.put(LottoTier.FIRST, 1);
        resultMap.put(LottoTier.SECOND, 1);
        resultMap.put(LottoTier.THIRD, 1);
        resultMap.put(LottoTier.FOURTH, 1);
        resultMap.put(LottoTier.FIFTH, 1);
        resultMap.put(LottoTier.NONE, 1);

        lottoResult = new LottoResult(resultMap);
    }

    @Test
    @DisplayName("결과에 맞는 수입금액을 도출하는 지 테스트")
    void getTotalPrize() {
        assertThat(lottoResult.getTotalPrize()).isEqualTo(2030205000);
    }

    @Test
    @DisplayName("결과와 구매 금액에 맞는 수익률을 도출하는 지 테스트")
    void getYield() {
        Money money = new Money(4000);
        assertThat(lottoResult.getYield(money)).isEqualTo(507551.25);
    }
}
