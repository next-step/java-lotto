package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoNumber;
import lotto.domain.Ranking;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void 당첨_번호와_몇개가_일치하는지_판단할_수_있다() {
        // given
        LottoCalculator calculator = LottoCalculator.getInstance();
        List<LottoNumber> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        LottoNumber bonusNum = new LottoNumber(10);
        List<LottoNumber> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 8).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        // when
        Ranking calculated = calculator.calculate(winningNumbers, userNumbers, bonusNum);

        // then
        assertThat(calculated.getNormalNumberMatchCount()).isEqualTo(5);
        assertThat(calculated).isEqualTo(Ranking.THIRD);
    }

    @Test
    void 보너스볼을_2등_3등을_제외하고는_판단하지_않는다() {
        LottoCalculator calculator = LottoCalculator.getInstance();
        List<LottoNumber> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        LottoNumber bonusNum = new LottoNumber(10);
        List<LottoNumber> userNumbers = Arrays.asList(1, 2, 3, 4, 10, 8).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        Ranking calculated = calculator.calculate(winningNumbers, userNumbers, bonusNum);

        assertThat(calculated).isEqualTo(Ranking.FOURTH);

    }
}
