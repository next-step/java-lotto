package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import lotto.service.LottoCountCalculator;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void 당첨_번호와_몇개가_일치하는지_판단할_수_있다() {
        // given
        LottoCountCalculator calculator = LottoCountCalculator.getInstance();
        LottoNumbers lotteryNumbers = LottoNumbers.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber bounusNum = new LottoNumber(8);
        LottoNumbers userNumbers = LottoNumbers.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)));

        // when
        Ranking lottoResult = calculator.countLotteryNumber(userNumbers,
            new WinningLotto(lotteryNumbers, bounusNum));

        // then
        assertThat(lottoResult).isEqualTo(Ranking.TWO);
    }
}
