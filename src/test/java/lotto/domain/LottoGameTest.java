package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("LottoGame 자동")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "10:10", "14:14"}, delimiter = ':')
    void lottoGameOfAllAutoLottos(int input, int expected) {
        List<String> lottoStringList = new ArrayList<>();
        LottoGame lottoGame = LottoGame.of(input, lottoStringList);
        assertThat(lottoGame.getLottos().getSize()).isEqualTo(expected);
    }

    @DisplayName("LottoGame 자동 + 수동")
    @ParameterizedTest
    @MethodSource("provideNumbersHalf")
    void lottoGameOfHalfLottos(int input, String[] inputManualLottoNumbers, int expected) {
        List<String> lottoList = new ArrayList<>();

        for (String lottoNumbers : inputManualLottoNumbers) {
            lottoList.add(lottoNumbers);
        }
        LottoGame lottoGame = LottoGame.of(input, lottoList);
        assertThat(lottoGame.getLottos().getSize()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersHalf() {
        return Stream.of(
            Arguments.of(5, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45"}, 5),
            Arguments.of(10, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45", "5, 10, 11, 12, 20, 25"}, 10),
            Arguments.of(7, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45", "5, 10, 11, 12, 20, 25", "10, 15, 20, 21, 5, 9"}, 7)
        );
    }

    @DisplayName("LottoGame 수동")
    @ParameterizedTest
    @MethodSource("provideNumbersAllManual")
    void lottoGameOfAllManualLottos(int input, String[] inputManualLottoNumbers, int expected) {
        List<String> lottoList = new ArrayList<>();

        for (String lottoNumbers : inputManualLottoNumbers) {
            lottoList.add(lottoNumbers);
        }
        LottoGame lottoGame = LottoGame.of(input, lottoList);
        assertThat(lottoGame.getLottos().getSize()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersAllManual() {
        return Stream.of(
            Arguments.of(2, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45"}, 2),
            Arguments.of(3, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45", "5, 10, 11, 12, 20, 25"}, 3),
            Arguments.of(4, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45", "5, 10, 11, 12, 20, 25", "10, 15, 20, 21, 5, 9"}, 4)
        );
    }
}
