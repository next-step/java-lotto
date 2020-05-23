package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @MethodSource("provideLessThanZero")
    @DisplayName("로또 번호가 1보다 작은 경우")
    void validateLessThanZero(int number) {
        assertThatThrownBy(() -> createLotto(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideLessThanZero() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGreaterThan45")
    @DisplayName("로또 번호가 45보다 큰 경우")
    void validateGreaterThan45(int number) {
        assertThatThrownBy(() -> createLotto(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideGreaterThan45() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(46)
        );
    }

    @ParameterizedTest
    @MethodSource("provideProperLottoNumbers")
    @DisplayName("로또 번호 정상 생성")
    void properCreateLotto(int number) {
        Lotto lotto = this.createLotto(number);
        assertThat(lotto.getNumber()).isEqualTo(number);
    }

    private static Stream<Arguments> provideProperLottoNumbers() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(45),
                Arguments.of(31)
        );
    }
    private Lotto createLotto(int number) {
        return new Lotto(number);
    }
}