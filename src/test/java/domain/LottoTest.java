package domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또를 발급한다.")
    @Test
    void test01() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.numbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 생성 시 파라미터로 넘기는 리스트가 6자리가 아니거나, 6자리지만 중복 숫자가 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("testFixture")
    void test02(List<Integer> numbers, Class<Exception> expected) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(expected);
    }

    public static Stream<Arguments> testFixture() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), IllegalArgumentException.class),
                Arguments.of(List.of(1, 1, 2, 3, 4, 5), IllegalArgumentException.class)
        );
    }

    @DisplayName("리스트를 기반으로 로또 생성 시 정렬된다.")
    @Test
    void test03() {
        Lotto lotto = new Lotto(List.of(5, 6, 1, 2, 3, 4));

        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
