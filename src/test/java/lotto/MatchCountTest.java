package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchCountTest {

    private MatchCount matchCount;

    @BeforeEach
    void setUp() {
        matchCount = new MatchCount(0);
    }

    @Test
    void 일치하는_숫자_개수() {
        this.matchCount.calculateWinningMatchCount(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7), new LottoNumbers(Arrays.asList(1, 2, 3, 6, 7, 8)).getValues());
        assertThat(this.matchCount).isEqualTo(new MatchCount(4));
    }
}
