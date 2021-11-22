package lotto.domain;

import lotto.exception.BonusNumberException;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("1 ~ 45 사이의 값 6개와 보너스 번호를 입력하면 우승 번호가 생성된다")
    void winningLottoCreateTest() {
        String[] winningNums = new String[] {"1", "2", "3", "4", "5", "6"};
        LottoNumber bonus = LottoNumber.from(7);

        assertThat(WinningLotto.from(winningNums, bonus)).isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("1 ~ 45 이외의 값으로 생성시 LottoNumberException")
    void createWinningLottoNumberException() {
        String[] winningNums = new String[] {"-1", "0", "3", "4", "5", "46"};

        assertThatThrownBy(() -> WinningLotto.from(winningNums, LottoNumber.from(7))).isInstanceOf(LottoNumberException.class);
    }

    @ParameterizedTest
    @DisplayName("배열의 길이가 6이 아닌경우 WinningLottoCountException")
    @MethodSource
    void createWinningLottoCountException(String[] winningNums, LottoNumber bonus) {
        assertThatThrownBy(() -> WinningLotto.from(winningNums, bonus)).isInstanceOf(LottoNumbersCountException.class);
    }

    static Stream<Arguments> createWinningLottoCountException() {
        return Stream.of(
                Arguments.of(
                        new String[]{}, LottoNumber.from(1)
                ),
                Arguments.of(
                        new String[] {"1"}, LottoNumber.from(2)
                )
                ,Arguments.of(
                        new String[] {"1", "2", "3", "4", "5", "6", "7"}, LottoNumber.from(8)
                )
        );
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 이미 있는 로또 번호와 중복된다면 BonusNumException")
    @MethodSource
    void bonusNumException(LottoNumber bonus) {
        String[] winningNums = new String[] {"1", "2", "3", "4", "5", "6"};

        assertThatThrownBy(() -> WinningLotto.from(winningNums, bonus)).isInstanceOf(BonusNumberException.class);
    }

    static Stream<Arguments> bonusNumException() {
        return Stream.of(
                Arguments.of(
                    LottoNumber.from(1)
                ),
                Arguments.of(
                        LottoNumber.from(2)
                ),
                Arguments.of(
                        LottoNumber.from(3)
                ),
                Arguments.of(
                        LottoNumber.from(6)
                )
        );
    }
}