package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoPapersTest {
    private LottoPapers lottoPapers;

    @BeforeEach
    void PapersCreate() {
        lottoPapers = new LottoPapers(3);
    }

    @Test
    void getPapersSize() {
        Assertions.assertThat(lottoPapers.getPapersSize()).isEqualTo(3);
    }

    @Test
    void makeWinningTable() {
        Assertions.assertThat(lottoPapers.makeWinningTable(Arrays.asList()))
                .isEqualToComparingFieldByField(new WinningTable());
    }
}