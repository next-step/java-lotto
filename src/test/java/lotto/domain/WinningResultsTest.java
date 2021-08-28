package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {

    @Test
    @DisplayName("구매한 티켓의 당첨 결과를 확인한다.")
    void check_winning_results_test() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        LottoGenerator lottoGenerator = () -> new Lotto(new TreeSet<>(lottoNumbers));

        Lotto lotto = lottoGenerator.generateLotto();
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList(lotto));
        WinningResults winningResults = new WinningResults(lottoPaper, "1, 2, 3, 4, 5, 6");

        assertThat(winningResults.winningReport().awardResult().get(Award.FIRST)).isEqualTo(1);
        assertThat(winningResults.winningReport().rateOfReturn()).isNotNull();
    }
}
