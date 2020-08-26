package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WinningPaperTest {
    WinningPaper winningPaper;

    @BeforeEach
    void create() {
        winningPaper = new WinningPaper("1, 2, 3, 4, 5, 6");
    }

    @Test
    void getMatchCount() {
        Assertions.assertThat(winningPaper.getMatchCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }
}