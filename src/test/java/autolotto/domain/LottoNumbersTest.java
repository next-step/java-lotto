package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest extends LottoNumbersFactory {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = LottoNumbers.of(Set.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void lengthIsNotSixGiven_ThrowException() {
        assertThatThrownBy(() -> LottoNumbers.of(Set.of(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(LottoExceptionCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4 ,5, 6:6",
            "1, 2, 3, 4, 5, 43:5",
            "1, 2, 3, 4, 41, 42:4"
    }, delimiter = ':')
    void winningLottoGiven_ReturnMatchCount(String number, int matchCount) {
        assertThat(lottoNumbers.match(new WinningLotto(new LottoNumbers(of(number))))).isEqualTo(matchCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void numberIsContainedGiven_ReturnTrue(int number) {
        assertThat(lottoNumbers.contains(LottoNumber.of(number))).isTrue();
    }

    @Test
    void bonusBallGiven_ReturnTrue() {
        assertThat(lottoNumbers.checkBonus(new WinningLotto(LottoNumbers.of(Set.of(1,2,3,4,5,7)),LottoNumber.of(6)))).isTrue();
    }
}

