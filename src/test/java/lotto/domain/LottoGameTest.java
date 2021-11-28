package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    @DisplayName("LottoGame 생성자 테스트")
    public void constructor() {
        assertThat(new LottoGame(new LottoNumbers())).isEqualTo(new LottoGame(new LottoNumbers()));
    }

    @Test
    @DisplayName("로또에 당첨 됐는지 계산한다.")
    public void winLottoNumber() {
        LottoGame lottoGame = new LottoGame(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 16)));
        LottoNumbers lastWeekWinningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGame.matchLottoNumbers(lastWeekWinningNumbers, new BonusLottoNumber(1));
        assertThat(lottoGame.getMatchedCount())
                .isEqualTo(5);
    }
}
