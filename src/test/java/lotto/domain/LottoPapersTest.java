package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoPapersTest {
    private LottoPapers lottoPapers;

    @BeforeEach
    void create() {
        lottoPapers = new LottoStore(null, 3).makeLottoPapers();
    }

    @Test
    void getPapersSize() {
        Assertions.assertThat(lottoPapers.getPapersSize()).isEqualTo(3);
    }

    @Test
    void makeAll() {
        LottoPapers lottoPapers2 = new LottoStore(null, 3).makeLottoPapers();
        Assertions.assertThat(lottoPapers.addAll(lottoPapers2).getPapersSize())
                .isEqualTo(6);
    }
}