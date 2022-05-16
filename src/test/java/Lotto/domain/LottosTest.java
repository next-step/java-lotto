package Lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
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
    void lottosTest(Lottos lottos, Lotto winningLotto, Map<EqualLottoCntInfo, Integer> result) {
        Assertions.assertThat(lottos.findWinningLotto(winningLotto)).isEqualTo(result);
    }

    private static Stream<Arguments> lottoKindsCntArgs() {
        return Stream.of(
                arguments(5,
                        List.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))
                        ),
                        5, 3
                ),
                arguments(1,
                        List.of(
                                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)),
                                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))
                        ),
                        1, 7
                )
        );
    }

    @ParameterizedTest
    @MethodSource("lottoKindsCntArgs")
    @DisplayName("구매한 로또들 중에 수동갯수와 자동갯수를 확인하는 테스트")
    void lottoKindsCntArgsTest(int automaticLottosCnt, List<Lotto> passiveLottos, int automaticCnt, int passiveCnt) {
        Lottos lottos = Lottos.createLottosWithPassive(automaticLottosCnt, passiveLottos);

        Assertions.assertThat(lottos.getAutomaticLottoCnt()).isEqualTo(automaticCnt);
        Assertions.assertThat(lottos.getPassiveLottoCnt()).isEqualTo(passiveCnt);
    }
}
