import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidatesTest {
    @Test
    void create(){
        assertThat(new Candidates().size()).isEqualTo(0);
    }

    @Test
    void calculate_benefit_when_buy_three_lottos(){
        Candidates candidates = new Candidates();

        candidates.add(new Lotto(1, 2, 3, 4, 13, 14)); // match count : 4
        candidates.add(new Lotto(3, 4, 5, 6, 20, 30)); // match count : 0
        candidates.add(new Lotto(20, 35, 40, 41, 42, 43)); // match count : 1

        double benefit = candidates.calculateRatio(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 13, 14, 35, 36)))); // winning

        assertThat(benefit).isEqualTo(16.67);
    }
}
