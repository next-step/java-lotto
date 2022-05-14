package Lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottosTest {

    private static Stream<Arguments> lottosArgs() {
        return Stream.of(
                arguments(new Lottos(new Lotto[]{
                                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13))
                        }), new Lotto("1, 2, 3, 4, 5, 6", new Number(7)),
                        Map.of(EqualLottoCntInfo.FIRST, 1, EqualLottoCntInfo.BONUS, 2, EqualLottoCntInfo.NONE, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("lottosArgs")
    @DisplayName("로또 여러장 중에 당첨 갯수를 구한다.")
    void test(Lottos lottos, Lotto winningLotto, Map<EqualLottoCntInfo, Integer> result) {
        Assertions.assertThat(lottos.findWinningLotto(winningLotto)).isEqualTo(result);
    }

}
