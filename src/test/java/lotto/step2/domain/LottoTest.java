package lotto.step2.domain;

import lotto.step2.util.LottoNumberGenerator;
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
    @DisplayName("Lotto 객체를 생성하면, Lotto는 1~45까지의 수를 중복되지 않게 6개 가지고 있다.")
    void testLottoHasUniqueSixNumbers() {
        //given
        Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());

        //when
        Set<Integer> numbers = lotto.nums();

        //then
        assertThat(numbers)
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @ParameterizedTest
    @MethodSource("createIncompleteSizeSetCollections")
    @DisplayName("Lotto 객체를 생성할 때 6개의 수를 가지고 있지 않으면, IllegalArgumentException 예외가 발생한다.")
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
    @MethodSource("createIncompleteValueSetCollections")
    @DisplayName("Lotto 객체를 생성할 때 1이상 45이하의 수만을 가지고 있지 않으면, IllegalArgumentException 예외가 발생한다.")
    void throwExceptionIfNumsValueIsNotValid(final Set<Integer> nums) {
        //given, when, then
        assertThatThrownBy(() -> new Lotto(nums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("lotto nums value must be 1 ~ 45");
    }

    public static Stream<Arguments> createIncompleteValueSetCollections() {
        return Stream.of(
                Arguments.of(Set.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(Set.of(-1, 1, 2, 3, 4, 5)),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 50))
        );
    }
}
