package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.domain.LottoCountResult;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.service.LottoCountCalculator;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void 당첨_번호와_몇개가_일치하는지_판단할_수_있다() {
        // given
        LottoCountCalculator calculator = LottoCountCalculator.getInstance();
        LottoNumbers lotteryNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber bounusNum = new LottoNumber(6);
        LottoNumbers userNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)));

        // when
        LottoCountResult lottoResult = calculator.countLotteryNumber(lotteryNumbers, userNumbers, bounusNum);

        // then
        assertThat(lottoResult.getNormalSuccessCount()).isEqualTo(5);
        assertThat(lottoResult.getBonusSuccessCount()).isEqualTo(0);
    }
}