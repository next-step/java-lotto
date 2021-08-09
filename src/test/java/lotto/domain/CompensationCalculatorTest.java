package lotto.domain;

import lotto.common.MatchHits;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompensationCalculatorTest {

    @Test
    public void 맞춘횟수가_각각_주어졌을_때_보상액을_구할_수_있다(){
        //given
        CompensationCalculator calculator = new CompensationCalculator();
        MatchHits matchHits = MatchHits.create(1, 2, 1, 1);
        //when
        int compensation = calculator.calculateFromMatchCount(matchHits);
        //then
        assertThat(compensation).isEqualTo(2001605000);
    }
}
