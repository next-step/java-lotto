package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;

class LottoResultTest {

    @Test
    @DisplayName("전체 상금을 잘 계산하는지 확인한다.")
    void test1() {
        LottoResult lottoResult = new LottoResult(Map.of(Rank.FIRST, 1, Rank.SECOND, 1));
        Money expectingResult = new Money(Rank.findPrizeAmount(Rank.FIRST) + Rank.findPrizeAmount(Rank.SECOND));

        assertThat(lottoResult.totalPrizeAmount()).isEqualTo(expectingResult);
    }
}

