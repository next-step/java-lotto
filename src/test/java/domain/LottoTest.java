package domain;

import exception.InvalidRangeNumberException;
import exception.LottoCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.LottoNumberGenerator;
import strategy.PassivityLottoNumberGenerator;
import strategy.RandomLottoNumberGenerator;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private LottoNumberGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = it -> Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6));
    }

    @DisplayName("로또 생성")
    @Test
    void lotto() {
        Lotto lotto = Lotto.of(new RandomLottoNumberGenerator());

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("수동 로또 생성")
    @Test
    void lotto_passivity() {
        Lotto lotto = Lotto.of("1,3,5,7,9,45", new PassivityLottoNumberGenerator());

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).containsExactly(1, 3, 5, 7, 9, 45);
    }

    @DisplayName("수동 로또 생성시에 수동으로 등록한 번호 유효하지 않으면 exception 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,3,5,7", "0,45,46,47,48,49", "test"})
    void lotto_invalidPassivity(String input) {
        assertThatThrownBy(() -> Lotto.of(input, new PassivityLottoNumberGenerator()))
                .isInstanceOf(RuntimeException.class);

    }

    @DisplayName("당첨번호에 따른 상금을 계산")
    @Test
    void hasWinningNumber() {
        Lotto lotto = Lotto.of(lottoGenerator);

        int prize = lotto.hasWinningNumber(Arrays.asList(1, 3, 5, 7, 9, 11));

        assertThat(prize).isEqualTo(3);
    }

    @DisplayName("지난주 당첨 번호가 유효하지 않으면 exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 110})
    void hasWinningNumber_invalidNumber(int invalidNumber) {
        Lotto lotto = Lotto.of(lottoGenerator);

        assertThatThrownBy(() -> lotto.hasWinningNumber(Arrays.asList(1, 3, 5, 7, 9, invalidNumber)))
                .isInstanceOf(InvalidRangeNumberException.class);
    }


    @DisplayName("추가 당첨 번호 확인")
    @ParameterizedTest
    @CsvSource({"6, true", "7, false"})
    void hasBonusNumber(int bonusNumber, boolean excpect) {
        Lotto lotto = Lotto.of(lottoGenerator);

        boolean result = lotto.hasBonusNumber(bonusNumber);

        assertThat(result).isEqualTo(excpect);
    }

    @DisplayName("추가 당첨번호 유효하지 않으면 exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 110})
    void hasBonusNumber_invalidBonusNumber(int invalidNumber) {
        Lotto lotto = Lotto.of(lottoGenerator);

        assertThatThrownBy(() -> lotto.hasBonusNumber(invalidNumber))
                .isInstanceOf(InvalidRangeNumberException.class);
    }
}
