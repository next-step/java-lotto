package Lotto.domain;

import Lotto.domain.Lotto.MyLotto;
import Lotto.domain.Lotto.WinningLotto;
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
                arguments(new Lottos(new MyLotto[]{
                                new MyLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new MyLotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new MyLotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new MyLotto(Arrays.asList(8, 9, 10, 11, 12, 13))
                        }), new WinningLotto("1, 2, 3, 4, 5, 6", new Number(7)),
                        Map.of(EqualLottoCntInfo.FIRST, 1, EqualLottoCntInfo.BONUS, 2, EqualLottoCntInfo.NONE, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("lottosArgs")
    @DisplayName("로또 여러장 중에 당첨 갯수를 구한다.")
    void lottosTest(Lottos lottos, WinningLotto winningLotto, Map<EqualLottoCntInfo, Integer> result) {
        Assertions.assertThat(lottos.findWinningLotto(winningLotto)).isEqualTo(result);
    }

    private static Stream<Arguments> lottoKindsCntArgs() {
        return Stream.of(
                arguments(8,
                        List.of(
                        new MyLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new MyLotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        new MyLotto(Arrays.asList(3, 4, 5, 6, 7, 8))
                        ),
                        5, 3
                ),
                arguments(8,
                        List.of(
                                new MyLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new MyLotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new MyLotto(Arrays.asList(3, 4, 5, 6, 7, 8)),
                                new MyLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new MyLotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                                new MyLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new MyLotto(Arrays.asList(2, 3, 4, 5, 6, 7))
                        ),
                        1, 7
                )
        );
    }

    @ParameterizedTest
    @MethodSource("lottoKindsCntArgs")
    @DisplayName("구매한 로또들 중에 수동갯수와 자동갯수를 확인하는 테스트")
    void lottoKindsCntArgsTest(int allLottoCnt, List<MyLotto> passiveMyLottos, int automaticCnt, int passiveCnt) {
        Lottos lottos = Lottos.createLottosWithPassive(allLottoCnt, passiveMyLottos);

        Assertions.assertThat(lottos.getAllLottoCnt() - passiveMyLottos.size()).isEqualTo(automaticCnt);
        Assertions.assertThat(lottos.getPassiveLottoCnt()).isEqualTo(passiveCnt);
    }

    private static Stream<Arguments> passiveLottoMatchArgs() {
        return Stream.of(
                arguments(3,
                        List.of(
                                new MyLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new MyLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                new MyLotto(Arrays.asList(13, 14, 15, 16, 17, 18))
                        ),
                        new WinningLotto("1, 2, 3, 4, 5, 6", new Number(7)),
                        Map.of(EqualLottoCntInfo.FIRST, 1, EqualLottoCntInfo.NONE, 2)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("passiveLottoMatchArgs")
    @DisplayName("수동 로또번호가 잘 포함되어있는지 확인하는 테스트")
    void passiveLottoMatchTest(int allLottoCnt, List<MyLotto> passiveMyLottos, WinningLotto winningLotto, Map<EqualLottoCntInfo, Integer> result) {
        Lottos lottos = Lottos.createLottosWithPassive(allLottoCnt, passiveMyLottos);

        Assertions.assertThat(lottos.findWinningLotto(winningLotto)).isEqualTo(result);
    }
}
