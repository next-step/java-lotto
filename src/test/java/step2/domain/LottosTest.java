package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class LottosTest {


    @DisplayName("로또의 갯수들이 로또티켓들의 갯수에 맞게 생성되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createLotto")
    void create(Lotto lotto1, Lotto lotto2, Lotto lotto3) {
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
        Assertions.assertThat(lottos.isLottoTicketsCount(3)).isTrue();
    }

    private static Stream<Arguments> createLotto() {
        return Stream.of(Arguments.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
                ),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))));
    }
}
