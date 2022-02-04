package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void 당첨_번호와_몇개가_일치하는지_판단할_수_있다() {
        // given
        LottoCalculator calculator = LottoCalculator.getInstance();
        List<Integer> lotteryNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bounusNum = 6;
        List<Integer> userNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8));

        // when
        LottoResult lottoResult = calculator.countLotteryNumber(lotteryNumbers, userNumbers, bounusNum);

        // then
        assertThat(lottoResult.getNormalSuccessCount()).isEqualTo(5);
        assertThat(lottoResult.getBonusSuccessCount()).isEqualTo(0);
    }
}