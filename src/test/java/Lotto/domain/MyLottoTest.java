package Lotto.domain;

import Lotto.exception.SameNumberException;
import Lotto.exception.WrongNumberFormatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class MyLottoTest {

    private static Stream<Arguments> lottoArgs() {
        return Stream.of(
                arguments(new MyLotto(Arrays.asList(1,2,3,4,5,6)), new WinningLotto(Arrays.asList(1,2,3,4,5,10)), 5),
                arguments(new MyLotto(Arrays.asList(1,2,3,4,5,6)), new WinningLotto(Arrays.asList(1,10,11,12,13,14)), 1),
                arguments(new MyLotto(Arrays.asList(45,44,43,3,2,1)), new WinningLotto(Arrays.asList(1,2,3,43,44,45)), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoArgs")
    @DisplayName("당첨된 번호가 몇개인지 확인한다")
    public void checkEqualLottoNumber(MyLotto myLotto, WinningLotto winningLotto, int equalNum) {
        Assertions.assertThat(myLotto.findWinningLottoCnt(winningLotto)).isEqualTo(equalNum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3"})
    @DisplayName("당첨번호의 갯수나 형식이 맞지않으면 예외를 던진다")
    public void validateWrongNumberFormatTest(String numbers) {
        assertThrows(WrongNumberFormatException.class, (
        ) -> new WinningLotto(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 1, 1, 1, 1", "1, 2, 3, 4, 5, 5"})
    @DisplayName("당첨숫자 중에 중복이 있으면 예외를 던진다")
    public void validateSameNumberFormatTest(String numbers) {
        assertThrows(SameNumberException.class, (
        ) -> new WinningLotto(numbers));
    }

    private static Stream<Arguments> bonusValidateArgs() {
        return Stream.of(
                arguments("1, 2, 3, 4, 5, 6", new Number(4)),
                arguments("10, 12, 13, 14, 25, 36", new Number(12)),
                arguments("8, 12, 31, 41, 25, 45", new Number(45))
        );
    }

    @ParameterizedTest
    @MethodSource("bonusValidateArgs")
    @DisplayName("당첨숫자와 보너스번호가 겹치면 예외를 던진다.")
    public void sameBonusNumberExceptionTest(String winningNumber, Number bonus ) {
        assertThrows(SameNumberException.class, (
        ) -> new WinningLotto(winningNumber, bonus));
    }

}
