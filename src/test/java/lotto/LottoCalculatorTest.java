package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void 당첨_번호와_몇개가_일치하는지_판단할_수_있다() {
        LottoCalculator calculator = LottoCalculator.getInstance();
        List<Integer> lotteryNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(calculator.countLotteryNumber(lotteryNumbers, userNumbers)).isEqualTo(6);
    }

}