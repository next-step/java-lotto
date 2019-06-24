package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberCheckerTest {
    private List<Integer> INPUT_SAMPLE_WINNER_NUMBERS = Arrays.asList(1,2,3,4,5,6);

    @Test
    void 당첨번호와_입력을_비교하여_일치한_개수를_반환한다() {
        NumberChecker checker = new NumberChecker(INPUT_SAMPLE_WINNER_NUMBERS);

        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(checker.validate(ticket)).isEqualTo(6);
    }
}
