package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoPapersTest {
    private LottoPapers lottoPapers;

    @BeforeEach
    void PapersCreate() {
        lottoPapers = new LottoStore(null, 3).makeLottoPapers();
    }

    @Test
    void getPapersSize() {
        Assertions.assertThat(lottoPapers.getPapersSize()).isEqualTo(3);
    }
}