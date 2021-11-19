package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @ParameterizedTest
    @MethodSource("constructorMethodSource")
    @DisplayName("LottoResult 는 6개의 일반 번호와 1개의 보너스 번호로 자신을 생성할 수 있다.")
    void constructorMethod(String numbers, String bonusNumber) {
        // given
        LottoResult self = new LottoResult(numbers, bonusNumber);

        // when
        LottoResult other = new LottoResult(numbers, bonusNumber);

        // then
        assertThat(self).isEqualTo(other);
    }

    static Stream<Arguments> constructorMethodSource() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", "7"),
                Arguments.of("39, 40, 41, 42, 43, 44", "45")
        );
    }

    @ParameterizedTest
    @MethodSource("matchCountMethodSource")
    @DisplayName("Lotto 는 LottoResult 와 비교하여 일반번호 중 몇개가 일치하는지 반환할 수 있다.")
    void matchCountMethod(String input, String win, String bonus, int result) {
        // given
        LottoResult self = new LottoResult(win, bonus);
        Lotto lotto = new Lotto(input);

        // when
        final int matchCount = self.matchCount(lotto);

        // then
        assertThat(matchCount).isEqualTo(result);
    }

    static Stream<Arguments> matchCountMethodSource() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6", "7", 6),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 8", "7", 5),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 8, 9", "7", 4),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 8, 9, 10", "7", 3),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 8, 9, 10, 11", "7", 2),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 8, 9, 10, 11, 12", "7", 1),
                Arguments.of("1, 2, 3, 4, 5, 6", "8, 9, 10, 11, 12, 13", "7", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("hasBonusMethodSource")
    @DisplayName("LottoResult 는 Lotto 와 비교하여 보너스 번호를 가지고 있는지 반환할 수 있다.")
    void hasBonusMethod(String input, String win, String bonus, boolean result) {
        // given
        LottoResult self = new LottoResult(win, bonus);
        Lotto lotto = new Lotto(input);

        // when
        final boolean hasBonus = self.hasBonus(lotto);

        // then
        assertThat(hasBonus).isEqualTo(result);
    }

    static Stream<Arguments> hasBonusMethodSource() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 7", "1, 2, 3, 4, 5, 6", "7", true),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 8", "7", false),
                Arguments.of("1, 2, 3, 4, 7, 6", "1, 2, 3, 4, 8, 9", "7", true),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 8, 9, 10", "7", false),
                Arguments.of("1, 2, 3, 7, 5, 6", "1, 2, 8, 9, 10, 11", "7", true),
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 8, 9, 10, 11, 12", "7", false),
                Arguments.of("1, 2, 7, 4, 5, 6", "8, 9, 10, 11, 12, 13", "7", true)
        );
    }
}
