package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {

    @Test
    @DisplayName("구매한 티켓의 당첨 결과를 확인한다.")
    void check_winning_results_test() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoGenerator lottoGenerator = () -> new Lotto(lottoNumbers);

        Lotto lotto = lottoGenerator.generateLotto();
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList(lotto));
        WinningResults winningResults = new WinningResults("1, 2, 3, 4, 5, 6");
        winningResults.checkWinning(lottoPaper);

        assertThat(winningResults.winningReport().awardResult().get(Award.FIRST)).isEqualTo(1);
        assertThat(winningResults.winningReport().rateOfReturn()).isNotNull();
    }
}
