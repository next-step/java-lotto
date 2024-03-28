package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 당첨 갯수 세기")
    @ParameterizedTest
    @MethodSource("generateData")
    void count_matching_lottos_test(Lottos autoLottos, List<Integer> winningNo) {
        LottoGame game = new LottoGame(autoLottos);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 2);

        assertThat(game.countLottosByMatchingCount(winningNo)).isEqualTo(map);

    }

    @DisplayName("수익률 구하기")
    @ParameterizedTest
    @MethodSource("generateData")
    void profit_rate_test(Lottos autoLottos, List<Integer> winningNo) {
        LottoGame game = new LottoGame(autoLottos);
        game.countLottosByMatchingCount(winningNo);
        double rate = game.profitRate();
        assertThat(rate).isEqualTo(763.75);
    }

    static Stream<Arguments> generateData() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 10, 20, 30));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 20, 30));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 44, 13));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 44, 23));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        List<Integer> winningNo = List.of(1, 2, 3, 4, 44, 45);
        return Stream.of(
                Arguments.of(lottos, winningNo)
        );
    }

}
