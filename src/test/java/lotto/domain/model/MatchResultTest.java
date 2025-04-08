package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchResultTest {
    @DisplayName("당첨 번호를 생성한다.")
    @Test
    void createWinningNumbersTest() {
        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class, () -> new MatchResult(winNumbers, bonusNumber));
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitTest() {
        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLotto(new LottoNumbers(List.of(7, 8, 9, 10, 11, 12)));
        lottoWallet.addLotto(new LottoNumbers(List.of(1, 2, 3, 7, 8, 9)));

        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        MatchResult result = lottoWallet.countMatches(winNumbers, bonusNumber);

        assertThat(result.calculateProfit(2000)).isEqualTo(2.5);
    }
}
