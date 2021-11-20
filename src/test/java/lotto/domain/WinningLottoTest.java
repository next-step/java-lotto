package lotto.domain;

import lotto.exception.LottoNumberException;
import lotto.exception.WinningLottoCountException;
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
    @DisplayName("1 ~ 45 사이의 값 6개를 입력하면 우승 번호가 생성된다")
    void winningLottoCreateTest() {
        String[] winningNums = new String[] {"1", "2", "3", "4", "5", "6"};

        assertThat(WinningLotto.from(winningNums)).isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("1 ~ 45 이외의 값으로 생성시 LottoNumberException")
    void createWinningLottoNumberException() {
        String[] winningNums = new String[] {"-1", "0", "3", "4", "5", "46"};

        assertThatThrownBy(() -> WinningLotto.from(winningNums)).isInstanceOf(LottoNumberException.class);
    }

    @ParameterizedTest
    @DisplayName("배열의 길이가 6이 아닌경우 WinningLottoCountException")
    @MethodSource
    void createWinningLottoCountException(String[] winningNums) {
        assertThatThrownBy(() -> WinningLotto.from(winningNums)).isInstanceOf(WinningLottoCountException.class);
    }

    static Stream<Arguments> createWinningLottoCountException() {
        return Stream.of(
                Arguments.of(
                        (Object) new String[]{}
                ),
                Arguments.of(
                        (Object) new String[] {"1"}
                )
                ,Arguments.of(
                        (Object) new String[] {"1", "2", "3", "4", "5", "6", "7"}
                )
        );
    }

}