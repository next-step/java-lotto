package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LottoPaperTest {
    LottoPaper lottoPaper;

    @BeforeEach
    public void createLottoPaper() {
        lottoPaper = new LottoPaper(Arrays.asList(new LottoNum(1), new LottoNum(2), new LottoNum(3)
                , new LottoNum(4), new LottoNum(5), new LottoNum(6)));
    }

    @Test
    @DisplayName("중복체크")
    void testValidReduplication() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(Arrays.asList(new LottoNum(1), new LottoNum(1), new LottoNum(3)
                        , new LottoNum(4), new LottoNum(5), new LottoNum(6))));
    }

    @Test
    @DisplayName("최대 6자리까지 생성 체크")
    void testValidListSize() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(Arrays.asList(new LottoNum(1), new LottoNum(2), new LottoNum(3)
                        , new LottoNum(4), new LottoNum(5), new LottoNum(6), new LottoNum(7))));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:5", "5:6"}, delimiter = ':')
    void getLottoNumbers(Integer index, Integer value) {
        Assertions.assertThat(lottoPaper.getLottoNumbers().get(index).getLottoNum())
                .isEqualTo(value);
    }

    @Test
    void getMatchCount() {
        Assertions.assertThat(lottoPaper.getMatchCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @Test
    void testGetMatchCount() {
        Assertions.assertThat(lottoPaper.getMatchCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @Test
    void getWinninLottoNumberToIntegerList() {
        Assertions.assertThat(lottoPaper.getLottoNumberToIntegerList())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void isContain() {
        Assertions.assertThat(lottoPaper.isContain(LottoNum.of(6))).isTrue();
        Assertions.assertThat(lottoPaper.isContain(LottoNum.of(7))).isFalse();
    }
}