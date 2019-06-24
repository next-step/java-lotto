package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("총 당첨 금액을 확인한다")
    @Test
    void getLottoResult_totalAmount() {
        List<Prize> prizes = Arrays.asList(
                Prize.FIRST,
                Prize.SECOND);
        long totalAmount = Prize.FIRST.getMoney() + Prize.SECOND.getMoney();

        LottoResult result = LottoResult.of(prizes);

        assertThat(result.getTotalMoney()).isEqualTo(totalAmount);
    }

    @DisplayName("당첨된 등수의 개수를 확인한다")
    @Test
    void getLottoResult_count() {
        List<Prize> prizes = Arrays.asList(
                Prize.FIRST,
                Prize.FIRST,
                Prize.SECOND);

        LottoResult result = LottoResult.of(prizes);

        assertThat(result.getCount(Prize.FIRST)).isEqualTo(2);
        assertThat(result.getCount(Prize.SECOND)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또가 없는 경우")
    @Test
    void getPrizeSummary() {
        List<Prize> prizes = Arrays.asList(
                Prize.NONE,
                Prize.NONE);

        LottoResult result = LottoResult.of(prizes);

        assertThat(result.getCount(Prize.NONE)).isEqualTo(2);
        assertThat(result.getTotalMoney()).isEqualTo(0);
    }
}
