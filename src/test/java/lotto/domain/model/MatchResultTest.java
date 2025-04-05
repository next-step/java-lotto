package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitTest() {
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto2 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLotto(lotto1);
        lottoWallet.addLotto(lotto2);

        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));
        MatchResult result = lottoWallet.countMatches(winNumbers);

        assertThat(result.calculateProfit(2000)).isEqualTo(1.5);
    }
}
