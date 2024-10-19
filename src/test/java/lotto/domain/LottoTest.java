package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또가 잘 생성되는지")
    @Test
    void lottoTest() {
        assertThat(new Lotto(1, 2, 3, 4, 5, 6))
                .isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @DisplayName("숫자가 아닌 값으로 로또가 생성될 경우 NumberFormatException을 잘 반환하는지")
    @Test
    void lottoTest_withNonNumericValue() {
        assertThatThrownBy(() -> new Lotto("abcd"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("6개가 아닌 숫자로 로또가 생성될 경우 IllegalArgumentException을 잘 반환하는지")
    @ParameterizedTest
    @MethodSource("numberArraysWithNonSixLength")
    void lottoTest_withNonSixLengthArgument(int[] arguments) {
        assertThatThrownBy(() -> new Lotto(arguments))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> numberArraysWithNonSixLength() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of((Object) new int[]{})
        );
    }

    @DisplayName("로또가 다른 로또와 비교해서 겹치는 숫자의 개수를 잘 반환하는지")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6/6", "1,2,3,4,5,7/5", "1,2,3,4,7,8/4", "1,2,3,7,8,9/3", "1,2,7,8,9,10/2", "1,7,8,9,10,11/1", "7,8,9,10,11,12/0"}, delimiter = '/')
    void matchTest(String lottoNumbers, int expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");

        assertThat(lotto.countMatchingNumbers(winningLotto))
                .isEqualTo(expected);
    }

    @DisplayName("로또의 Contains 메서드가 올바른 결과를 반환하는지")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6/1/true", "1,2,3,4,5,6/7/false"}, delimiter = '/')
    void containsTest(String lottoNumbers, int number, boolean expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lotto.contains(lottoNumber))
                .isEqualTo(expected);
    }

}
