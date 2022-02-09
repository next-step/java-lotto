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
}
