package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.dto.LottoWinningResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 당첨 번호를 전달하면 로또 당첨 여부와 당첨금을 알 수 있다.")
    @Test
    void getWinningInfo() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(45, 1, 6, 32, 8, 5);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers);
        Lotto lotto = new Lotto(new LottoWinningRules(), lottoNumbers);

        LottoWinningResult lottoWinningResult = lotto.getWinningResult(lottoWinningNumbers);

        assertThat(lottoWinningResult.isWin()).isEqualTo(true);
        assertThat(lottoWinningResult.getNumberOfMatches()).isEqualTo(3);
        assertThat(lottoWinningResult.getPrizeMoney()).isEqualTo(5000);
    }

}