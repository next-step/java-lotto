package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("1 ~ 45사이의 중복되지 않는 6개의 값을 Lotto 생성자로 입력하면, Lotto 객체가 생성된다.")
    void testLottoHasUniqueSixNumbers() {
        //given
        Lotto lotto = new Lotto(Set.of(1, 10, 20, 30, 40, 45));

        //when
        Set<LottoNumber> numbers = lotto.nums();

        //then
        assertThat(numbers)
                .hasSize(6)
                .allMatch(number -> number.number() >= 1 && number.number() <= 45);
    }

    @ParameterizedTest
    @MethodSource("createIncompleteSizeSetCollections")
    @DisplayName("Lotto 객체를 생성할 때, 6개의 수를 가지고 있지 않으면 IllegalArgumentException 예외가 발생한다.")
    void throwExceptionIfNumsSizeIsNot6(final Set<Integer> nums) {
        //given, when, then
        assertThatThrownBy(() -> new Lotto(nums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("lotto nums size must be 6");
    }

    public static Stream<Arguments> createIncompleteSizeSetCollections() {
        return Stream.of(
                Arguments.of(Set.of()),
                Arguments.of(Set.of(1)),
                Arguments.of(Set.of(1, 2)),
                Arguments.of(Set.of(1, 2, 3)),
                Arguments.of(Set.of(1, 2, 3, 4)),
                Arguments.of(Set.of(1, 2, 3, 4, 5)),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoObjects")
    @DisplayName("Lotto 객체를 toString 하면, 해당 Lotto 객체가 가진 숫자들을 모아서 String으로 반환한다.")
    void testLottoToString(Set<Integer> integerSet, String expectedResult) {
        // given
        Lotto lotto = new Lotto(integerSet);

        // when
        String lottoString = lotto.toString();

        // then
        assertThat(lottoString).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> generateLottoObjects() {
        return Stream.of(
                Arguments.of(Set.of(45, 7, 1, 33, 15, 22), "[1, 7, 15, 22, 33, 45]"),
                Arguments.of(Set.of(30, 25, 8, 12, 40, 44), "[8, 12, 25, 30, 40, 44]")
        );
    }


    @ParameterizedTest
    @MethodSource("inputInvalidWinnerLotto")
    @DisplayName("Lotto 객체를 생성할 때 입력 번호로 1 ~ 45까지의 수를 중복되지 않게 6개를 입력하지 않으면, IllegalArgumentException 예외가 발생한다.")
    void testLottoHasUniqueSixNumbers(final Set<Integer> integers) {
        //given, when, then
        assertThatThrownBy(() -> new Lotto(integers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> inputInvalidWinnerLotto() {
        return Stream.of(
                Arguments.of((Set.of(10, 12, 30, 34))),
                Arguments.of((Set.of(10, 12, 30, 34, 45))),
                Arguments.of((Set.of(10, 12, 30, 34, 40, 47))),
                Arguments.of((Set.of(10, 12, 30, 34, 40, -1))),
                Arguments.of((Set.of(10, 12, 30, 34, 40, 49, 50)))
        );
    }

    @Test
    @DisplayName("Lotto 객체는 수정할 수 없는 Collection이므로 수정하려고 하면, UnsupportedOperationException 예외가 발생한다.")
    void throwUnsupportedOperationExceptionWhenModifyNumbers() {
        // given
        final Lotto lotto = new Lotto(Set.of(10, 12, 30, 34, 40, 45));

        Set<LottoNumber> nums = lotto.nums();

        // when, then
        assertThatThrownBy(() -> nums.remove(10))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
