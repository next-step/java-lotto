package lotto.domain;

import lotto.exception.AlreadyAppliedBonusNumberException;
import lotto.exception.DuplicatedBonusNumberException;
import lotto.exception.WinningLottoNonPositiveNumberException;
import lotto.exception.WinningLottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoGame.createManual;
import static lotto.domain.LottoNumber.valueOf;
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

    @DisplayName("new_예외_음수")
    @ParameterizedTest
    @ValueSource(strings = {"-1,-3,2,3,5,6",
            "21,23,37,42,15,-1"})
    void new_예외_음수(String input) {
        // When, Then
        assertThatExceptionOfType(WinningLottoNonPositiveNumberException.class)
                .isThrownBy(() -> new WinningLottoNumber(input));
    }

    @DisplayName("new_예외_부족한_번호_수")
    @ParameterizedTest
    @ValueSource(strings = {"21,23,37,42",
            "31,22,43,44"})
    void new_예외_부족한_번호_수(String input) {
        // When, Then
        assertThatExceptionOfType(WinningLottoNumberCountException.class)
                .isThrownBy(() -> new WinningLottoNumber(input));
    }

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            createManual(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6)))),
            createManual(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(7)))),
            createManual(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(8), valueOf(9)))),
            createManual(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(10), valueOf(11), valueOf(12)))),
            createManual(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(13), valueOf(14), valueOf(15))))
    );

    @DisplayName("decidePrize_정상")
    @Test
    void decidePrize_정상() {
        // Given
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6");
        winningLottoNumber.applyBonusNumber("7");
        LottoGames lottoGames = new LottoGames(mockLottoGameList);
        final int EXPECTED_FIRST_COUNT = 1;
        final int EXPECTED_SECOND_COUNT = 1;
        final int EXPECTED_THIRD_COUNT = 0;
        final int EXPECTED_FOURTH_COUNT = 1;
        final int EXPECTED_FIFTH_COUNT = 2;

        // When
        LottoResult lottoResult = winningLottoNumber.decidePrize(lottoGames);

        // Then
        assertThat(lottoResult.get(FIRST)).isEqualTo(EXPECTED_FIRST_COUNT);
        assertThat(lottoResult.get(SECOND)).isEqualTo(EXPECTED_SECOND_COUNT);
        assertThat(lottoResult.get(THIRD)).isEqualTo(EXPECTED_THIRD_COUNT);
        assertThat(lottoResult.get(FOURTH)).isEqualTo(EXPECTED_FOURTH_COUNT);
        assertThat(lottoResult.get(FIFTH)).isEqualTo(EXPECTED_FIFTH_COUNT);
    }

    @DisplayName("applyBonusNumber_정상")
    @Test
    void applyBonusNumber_정상() {
        // Given
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6");
        final String bonusNumberInput = "7";

        // When, Then
        assertDoesNotThrow(() -> winningLottoNumber.applyBonusNumber(bonusNumberInput));
    }

    @DisplayName("applyBonusNumber_예외1_비정상적인_보너스_번호_변경_시도_예외")
    @Test
    void applyBonusNumber_예외1_비정상적인_보너스_번호_변경_시도_예외() {
        // Given
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6");
        final String bonusNumberInput = "7";

        // When, Then
        assertDoesNotThrow(() -> winningLottoNumber.applyBonusNumber(bonusNumberInput));

        assertThatExceptionOfType(AlreadyAppliedBonusNumberException.class)
                .isThrownBy(() -> winningLottoNumber.applyBonusNumber(bonusNumberInput));
    }

    @DisplayName("applyBonusNumber_예외2_당첨번호와_중복되는_보너스번호_적용_예외")
    @Test
    void applyBonusNumber_예외2_당첨번호와_중복되는_보너스번호_적용_예외() {
        // Given
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6");
        final String bonusNumberInput = "6";

        // When, Then
        assertThatExceptionOfType(DuplicatedBonusNumberException.class)
                .isThrownBy(() -> winningLottoNumber.applyBonusNumber(bonusNumberInput));
    }
}