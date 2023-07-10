package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoTest {

    static Stream<Arguments> createLotto() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 4, 5, 6)),
                arguments(List.of(11, 2, 3, 4, 5, 6)),
                arguments(List.of(1, 22, 3, 44, 5, 6)),
                arguments(List.of(1, 2, 33, 4, 15, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("createLotto")
    @DisplayName("여러 로또 넘버가 중복되지 않는지 테스트")
    void 로또_중복(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("여러 로또 넘버가 중복되는 않는지 테스트")
    void 로또_중복() {
        assertThatCode(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 넘버는 중복되면 안됩니다.");
    }
}
