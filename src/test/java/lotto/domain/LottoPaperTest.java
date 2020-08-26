package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoPaperTest {
    LottoPaper lottoPaper;

    @BeforeEach
    public void createLottoPaper() {
        lottoPaper = new LottoPaper(Arrays.asList(1, 2, 3, 4, 5, 6));
    }


    @Test
    void getLottoNumbers() {
        Assertions.assertThat(lottoPaper.getLottoNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}