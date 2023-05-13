package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

public class LottoCalculatorTests {
    @Test
    @DisplayName("구매한 금액으로 로또를 몇개 살수잇는지 확인")
    public void testGetCountOfLotto() {
        // given
        int purchaseAmount = 7000;
        int expectedCount = 7;

        // when
        int actualCount = LottoCalculator.getCountOfLotto(purchaseAmount);

        // then
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("구매한 금액시준 전체 수익 계산")
    public void testGetTotalProfit() {
        // given
        List<LottoNumber> lottos = Arrays.asList(
                new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoNumber(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new LottoNumber(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new LottoNumber(Arrays.asList(25, 26, 27, 28, 29, 30))
        );
        LottoNumber winningNumbers = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        int purchaseAmount = 5000;
        double expectedProfit = 400000.0;

        // when
        double actualProfit = LottoCalculator.getTotalProfit(lottos, winningNumbers, purchaseAmount);

        // then
        assertThat(actualProfit).isEqualTo(expectedProfit);
    }

}

