package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumber.from;
import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("WinningLottoNumber 테스트")
class WinningLottoNumberTest {

    @DisplayName("new_정상")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,7",
            "13,22,14,34,25,37",
            "21,23,35,42,15,37",
            "31,22,43,44,45,17",})
    void new_정상(String input) {
        assertDoesNotThrow(() -> new WinningLottoNumber(input));
    }

    @DisplayName("new_예외")
    @ParameterizedTest
    @CsvSource({"ㄱ,ㄴ,ㄷ",
            "-1,-3,2,3,5,6",
            "21,23,37,42,15,-1",
            "31,22,43,44",})
    void new_예외(String input) {
        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(input));
    }

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(7)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(8), from(9)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(10), from(11), from(12)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(13), from(14), from(15))))
    );

    @DisplayName("decidePrize_정상")
    @Test
    void decidePrize_정상() {
        // Given
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6");
        LottoGames lottoGames = new LottoGames(mockLottoGameList);
        final int EXPECTED_FIRST_COUNT = 1;
        final int EXPECTED_SECOND_COUNT = 1;
        final int EXPECTED_THIRD_COUNT = 1;
        final int EXPECTED_FOURTH_COUNT = 2;

        // When
        LottoResult lottoResult = winningLottoNumber.decidePrize(lottoGames);

        // Then
        assertThat(lottoResult.get(FIRST)).isEqualTo(EXPECTED_FIRST_COUNT);
        assertThat(lottoResult.get(SECOND)).isEqualTo(EXPECTED_SECOND_COUNT);
        assertThat(lottoResult.get(THIRD)).isEqualTo(EXPECTED_THIRD_COUNT);
        assertThat(lottoResult.get(FOURTH)).isEqualTo(EXPECTED_FOURTH_COUNT);
    }
}