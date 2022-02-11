package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Statistics;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    
    @Test
    void 매칭되는_숫자_갯수를_잘_찾는지_확인() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(2, 4, 6, 8, 10, 12);
        Statistics statistics = new Statistics();
        assertThat(3).isEqualTo(statistics.getMatchCount(lottoNumbers, winningNumbers));
    }
    
    @Test
    void 매칭되는_숫자_갯수를_잘_찾는지_확인2() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 6, 8);
        List<Integer> winningNumbers = Arrays.asList(2, 4, 6, 8, 10, 12);
        Statistics statistics = new Statistics();
        assertThat(4).isEqualTo(statistics.getMatchCount(lottoNumbers, winningNumbers));
    }
    
    @Test
    void 보너스볼과_일치하는지_확인() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 6, 8);
        int bonusBall = 6;
        Statistics statistics = new Statistics();
        assertThat(statistics.getBonusScore(lottoNumbers, bonusBall)).isTrue();
    }
    
    @Test
    void 보너스볼과_불일치하는지_확인() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 6, 8);
        int bonusBall = 10;
        Statistics statistics = new Statistics();
        assertThat(statistics.getBonusScore(lottoNumbers, bonusBall)).isFalse();
    }
    
}