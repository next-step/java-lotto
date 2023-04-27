package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Match;
import step2.domain.Rate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class RateTest {

    @Test
    void 수익률_계산() {

        // given
        int price = 14000;

        Map<Match, Integer> numberOfMatches = new HashMap<>();

        numberOfMatches.put(new Match(3, false), 1);
        numberOfMatches.put(new Match(4, false), 0);
        numberOfMatches.put(new Match(5, false), 0);
        numberOfMatches.put(new Match(6, false), 0);

        // when
        float result = Rate.calculateRate(numberOfMatches, price);

        // then
        assertThat(result).isEqualTo(0.35f);
    }
}
