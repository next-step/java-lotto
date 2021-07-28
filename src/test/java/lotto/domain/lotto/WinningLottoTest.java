package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("당첨된 로또")
class WinningLottoTest {

    public static Stream<Arguments> validLotto() {
        return Stream.of(
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                3L
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 11, 12)),
                4L
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 12)),
                5L
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                6L
            ));
    }

    @DisplayName("[성공] 일치하는 번호의 개수")
    @ParameterizedTest
    @MethodSource("validLotto")
    public void matchCount(WinningLotto winningLotto, NormalLotto normalLotto, long expected) {
        // given

        // when
        long matchCount = winningLotto.matchNumberCount(normalLotto);

        // then
        assertThat(matchCount).isEqualTo(expected);
    }
}
