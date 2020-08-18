package domain;

import exception.InvalidRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.RandomLottoNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 생성")
    @Test
    void lotto() {
        Lotto lotto = Lotto.of(new RandomLottoNumberGenerator());

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("당첨번호에 따른 상금을 계산")
    @Test
    void hasWinningNumber() {
        Lotto lotto = Lotto.of(() -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        int prize = lotto.hasWinningNumber(Arrays.asList(1, 3, 5, 7, 9, 11));

        assertThat(prize).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 110})
    void hasWinningNumber_invalidNumber(int invalidNumber) {
        Lotto lotto = Lotto.of(() -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        assertThatThrownBy(() -> lotto.hasWinningNumber(Arrays.asList(1, 3, 5, 7, 9, invalidNumber)))
                .isInstanceOf(InvalidRangeNumberException.class);
    }


    @ParameterizedTest
    @CsvSource({"6, true", "7, false"})
    void hasBonusNumber(int bonusNumber, boolean excpect) {
        Lotto lotto = Lotto.of(() -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        boolean result = lotto.hasBonusNumber(bonusNumber);

        assertThat(result).isEqualTo(excpect);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 110})
    void hasBonusNumber_invalidBonusNumber(int invalidNumber) {
        Lotto lotto = Lotto.of(() -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        assertThatThrownBy(() -> lotto.hasBonusNumber(invalidNumber))
                .isInstanceOf(InvalidRangeNumberException.class);
    }
}
