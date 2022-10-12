package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LottoTest {

    @DisplayName("생성할 때")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Create {

        @DisplayName("List<Integer>타입을 파라미터로 받을 수 있다.")
        @Test
        void create_by_List() {
            Lotto expected = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

            assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                    .isEqualTo(expected);
        }

        @DisplayName("List<String>타입을 파라미터로 받을 수 있다.")
        @Test
        void create_by_string() {
            Lotto expected = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

            assertThat(Lotto.of(List.of("1", "2", "3", "4", "5", "6")))
                    .isEqualTo(expected);
        }

        @DisplayName("1~45 사이의 숫자가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("generateOutOfRangeElements")
        void validate_number_range(Set<Integer> elements) {
            assertThatThrownBy(() -> new Lotto(elements))
                    .isExactlyInstanceOf(OutOfRangeLottoNumberException.class)
                    .hasMessage("로또 숫자의 범위를 벗어난 숫자가 포함되어 있습니다. 유효한 로또 숫자 범위 : 1 ~ 45");
        }

        @DisplayName("숫자 개수가 6개가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("generateInvalidSizeElements")
        void validate_size(Set<Integer> elements) {
            assertThatThrownBy(() -> new Lotto(elements))
                    .isExactlyInstanceOf(InvalidLottoNumberSizeException.class)
                    .hasMessage("올바르지 않은 로또 숫자 개수 입니다. 올바른 숫자 개수(중복제외) : 6");
        }

        private Stream<Set<Integer>> generateOutOfRangeElements() {
            return Stream.of(
                    Set.of(0, 1, 2, 3, 4, 5),
                    Set.of(1, 2, 3, 4, 5, 46)
            );
        }

        private Stream<Set<Integer>> generateInvalidSizeElements() {
            return Stream.of(
                    Set.of(1, 2, 3, 4, 5),
                    Set.of(1, 2, 3, 4, 5, 6, 7)
            );
        }
    }

    @DisplayName("오름 차순으로 정렬된 로또 숫자들을 문자형식으로 반환한다.")
    @Test
    void to_string() {
        String expected = "[1, 2, 3, 4, 5, 6]";

        String actual = new Lotto(List.of(4, 5, 3, 6, 1, 2)).toString();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("중복되는 숫자의 개수를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateMatchesElements")
    void count_matches(Set<Integer> elements, int expected) {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lastWeekLotto = new Lotto(elements);

        int actual = lotto.countMatches(lastWeekLotto);

        assertThat(actual).isEqualTo(expected);
    }

    private Stream<Arguments> generateMatchesElements() {
        return Stream.of(
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(Set.of(2, 3, 4, 5, 6, 7), 5),
                Arguments.arguments(Set.of(3, 4, 5, 6, 7, 8), 4),
                Arguments.arguments(Set.of(4, 5, 6, 7, 8, 9), 3),
                Arguments.arguments(Set.of(5, 6, 7, 8, 9, 10), 2),
                Arguments.arguments(Set.of(6, 7, 8, 9, 10, 11), 1),
                Arguments.arguments(Set.of(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
