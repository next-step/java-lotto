package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @DisplayName("buyAmount에 맞추어 로또를 발행")
    @Test
    void lottos() {
        Lottos lottos = Lottos.of(1, () -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottos.getLottos()).hasSize(1);
    }

    @DisplayName("저번주 당첨 번호 잘못 입력시 exception 발생")
    @ParameterizedTest
    @MethodSource("generateData")
    void getPrizes_invalidWinningNumber(List<Integer> input) {
        Lottos lottos = Lottos.of(1, () -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottos.getLottoResult(input)).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}
