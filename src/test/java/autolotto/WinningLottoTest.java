package autolotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static autolotto.LottoExceptionCode.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"3, 5, 6, 7, 8", " ", "3.5.6,3,4,2"})
    void LengthIsNotSixGiven_ReturnThrow(String number) {
        assertThatThrownBy(() -> new WinningLotto(number))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a, b, 8, 6, 5, 6"})
    void numberIsNotAllNumberGiven_ReturnThrow(String number) {
        assertThatThrownBy(() -> new WinningLotto(number))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_WINNING_NUMBER_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"46, 13, 1, 2, 3 ,4"})
    void numberIsOver45Given_ReturnThrow(String number) {
        assertThatThrownBy(() -> new WinningLotto(number))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_WINNING_NUMBER_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 2, 3, 4 ,5"})
    void numberIsDuplicatedGiven_ReturnThrow(String number) {
        assertThatThrownBy(() -> new WinningLotto(number))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPLICATED_WINNING_NUMBER.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4 ,5, 6:3"}, delimiter = ':')
    void numberGiven_ReturnContainResult(String number, int compare) {
        assertThat(new WinningLotto(number).contains(compare)).isTrue();
    }
}
