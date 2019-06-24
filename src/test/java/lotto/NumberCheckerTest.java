package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberCheckerTest {
    private List<Integer> INPUT_SAMPLE_WINNER_NUMBERS = Arrays.asList(1,2,3,4,5,6);

    LottoTicket sampleTicket;

    @BeforeEach
    void setUp() {
        sampleTicket = new LottoTicket(INPUT_SAMPLE_WINNER_NUMBERS);
    }

    @Test
    void 당첨번호와_입력을_비교하여_일치한_개수를_반환한다() {
        NumberChecker checker = new NumberChecker(sampleTicket);

        assertThat(checker.correct(sampleTicket)).isEqualTo(6);
    }
}
