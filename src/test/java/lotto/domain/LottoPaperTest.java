package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class LottoPaperTest {
    LottoPaper lottoPaper;

    @BeforeEach
    public void createLottoPaper() {
        lottoPaper = new LottoPaper(Arrays.asList(new LottoNum(1), new LottoNum(2), new LottoNum(3)
                , new LottoNum(4), new LottoNum(5), new LottoNum(6)));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:5", "5:6"}, delimiter = ':')
    void getLottoNumbers(Integer index, Integer value) {
        Assertions.assertThat(lottoPaper.getLottoNumbers().get(index).getLottoNum())
                .isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void getNumbers(int value) {
        Assertions.assertThat(lottoPaper.getLottoNumbersToIntegerList()).contains(value);
    }

    @Test
    void getMatchCount() {
        Assertions.assertThat(lottoPaper.getMatchCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @Test
    void testGetMatchCount() {
        Assertions.assertThat(lottoPaper.getMatchCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }
}