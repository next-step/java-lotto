package domain;

import exception.InvalidRangeNumberException;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private LottoNumberGenerator lottoGenerator;
    private List<LottoNumber> winningNumbers;

    @BeforeEach
    void setUp() {
        lottoGenerator = it -> Arrays.asList(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6));

        winningNumbers = Arrays.asList(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(7),
                LottoNumber.valueOf(9),
                LottoNumber.valueOf(11));
    }

    @DisplayName("로또 생성")
    @Test
    void lotto() {
        Lotto lotto = Lotto.of(new RandomLottoNumberGenerator());

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("수동 로또 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1,3,5,7,9,45", "45,9,7,5,3,1"})
    void lotto_passivity(String input) {
        Lotto lotto = Lotto.of(input, new PassivityLottoNumberGenerator());

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).containsExactly(1, 3, 5, 7, 9, 45);
    }

    @DisplayName("수동 로또 생성시에 수동으로 등록한 번호 유효하지 않으면 exception 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,3,5,7", "0,45,46,47,48,49", "1,2,3,3,4,5", "test"})
    void lotto_invalidPassivity(String input) {
        assertThatThrownBy(() -> Lotto.of(input, new PassivityLottoNumberGenerator()))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("당첨번호에 따른 상금을 계산")
    @Test
    void hasWinningNumber() {
        Lotto lotto = Lotto.of(lottoGenerator);

        int prize = lotto.hasWinningNumber(winningNumbers);

        assertThat(prize).isEqualTo(3);
    }

    @DisplayName("추가 당첨 번호 확인")
    @ParameterizedTest
    @CsvSource({"6, true", "7, false"})
    void hasBonusNumber(int bonusNumber, boolean excpect) {
        Lotto lotto = Lotto.of(lottoGenerator);

        boolean result = lotto.hasBonusNumber(LottoNumber.valueOf(bonusNumber));

        assertThat(result).isEqualTo(excpect);
    }
}
