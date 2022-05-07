package Lotto.domain;

import Lotto.exception.SameNumberException;
import Lotto.exception.WrongNumberFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class LottoTest {

    private static Stream<Arguments> lottoArgs() {
        return Stream.of(
                arguments(new Lotto(Arrays.asList(1,2,3,4,5,6)), new Lotto(Arrays.asList(1,2,3,4,5,10)), 5),
                arguments(new Lotto(Arrays.asList(1,2,3,4,5,6)), new Lotto(Arrays.asList(1,10,11,12,13,14)), 1),
                arguments(new Lotto(Arrays.asList(45,44,43,3,2,1)), new Lotto(Arrays.asList(1,2,3,43,44,45)), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoArgs")
    @DisplayName("당첨된 번호가 몇개인지 확인한다")
    public void checkEqualLottoNumber(Lotto lotto, Lotto winningLotto, int equalNum) {
        Assertions.assertEquals(lotto.findWinningLottoCnt(winningLotto), equalNum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3"})
    @DisplayName("당첨번호의 갯수나 형식이 맞지않으면 예외를 던진다")
    public void validateWrongNumberFormatTest(String numbers) {
        Assertions.assertThrows(WrongNumberFormatException.class, (
        ) -> new Lotto(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 1, 1, 1, 1", "1, 2, 3, 4, 5, 5"})
    @DisplayName("당첨숫자 중에 중복이 있으면 예외를 던진다")
    public void validateSameNumberFormatTest(String numbers) {
        Assertions.assertThrows(SameNumberException.class, (
        ) -> new Lotto(numbers));
    }
}
