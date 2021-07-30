package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
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
                new WinningLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new NormalLotto(new HashSet<>(Arrays.asList(1, 2, 3, 10, 11, 12))),
                3
            ),
            Arguments.of(
                new WinningLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new NormalLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 11, 12))),
                4
            ),
            Arguments.of(
                new WinningLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new NormalLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 12))),
                5
            ),
            Arguments.of(
                new WinningLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new NormalLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                6
            ));
    }

    @DisplayName("[성공] 일치하는 번호의 개수")
    @ParameterizedTest
    @MethodSource("validLotto")
    public void matchCount(WinningLotto winningLotto, NormalLotto normalLotto, int expected) {
        // given

        // when
        int matchCount = winningLotto.matchNumberCount(normalLotto);

        // then
        assertThat(matchCount).isEqualTo(expected);
    }
}
