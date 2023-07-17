package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoTest {

    static Stream<Arguments> createLottoSuccess() {
        return Stream.of(
            arguments(List.of(1, 2, 3, 4, 5, 6)),
            arguments(List.of(11, 2, 3, 4, 5, 6)),
            arguments(List.of(1, 22, 3, 44, 5, 6)),
            arguments(List.of(1, 2, 33, 4, 15, 6))
        );
    }

    static Stream<Arguments> createLottoLengthFail() {
        return Stream.of(
            arguments(List.of(1, 2, 3, 4, 5, 6, 7)),
            arguments(List.of(11, 2, 3, 4, 5)),
            arguments(List.of())
        );
    }

    static Stream<Arguments> createLottoDuplicateFail() {
        return Stream.of(
            arguments(List.of(1, 1, 3, 4, 5, 6)),
            arguments(List.of(2, 2, 2, 4, 5, 5)),
            arguments(List.of(1, 1, 1, 1, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("createLottoSuccess")
    @DisplayName("여러 로또 넘버가 중복되지 않으면 정상")
    void 로또_중복(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(createLottoNumbers(numbers)))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("createLottoDuplicateFail")
    @DisplayName("여러 로또 넘버가 중복되면 예외를 던진다.")
    void 로또_중복_예외(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(createLottoNumbers(numbers)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 넘버는 중복되면 안됩니다.");
    }

    @ParameterizedTest
    @MethodSource("createLottoLengthFail")
    @DisplayName("로또 번호는 6개가 아니면 예외를 던진다")
    void 로또_번호_6개가_아니면_예외_던진다(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(createLottoNumbers(numbers)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 6개이여야 합니다");
    }

    @ParameterizedTest
    @MethodSource("createLottoSuccess")
    @DisplayName("로또 번호는 6개가 아니면 정상 동작")
    void 로또_번호_6개이면_정상(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(createLottoNumbers(numbers)))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 로또에 포함되어 있는지 테스트")
    void 로또_포함() {
        Lotto lotto = new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isContain(new LottoNumber(3))).isTrue();
    }


    @Test
    @DisplayName("로또 번호가 로또에 포함되어 있는 않는 테스트")
    void 로또_포함_X() {
        Lotto lotto = new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isContain(new LottoNumber(11))).isFalse();
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> container) {
        return container.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
