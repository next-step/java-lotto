package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}