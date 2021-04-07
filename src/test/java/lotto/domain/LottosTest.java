package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottosTest {

    @Test
    @DisplayName("돈을 입력받은만큼 로또로 교환하기")
    void create() {
        Money money = Money.of(14000);
        Lottos lottos = Lottos.of(Lottos.exchange(money));

        assertThat(lottos.size()).isEqualTo(14);
    }

    static Stream<Arguments> checkedLottos() {
        return Stream.of(
                arguments(
                Lists.list(
                        new Lotto(LottoBalls.of(41, 2, 3, 4, 5, 6)),
                        new Lotto(LottoBalls.of(11, 12, 13, 14, 15, 16))
                ),
                new WinningLotto(LottoBalls.of(4, 5, 6, 41, 12, 13)),
                Lists.list(4, 2))
        );
    }

    @ParameterizedTest
    @DisplayName("로또 번호 당첨 개수 확인")
    @MethodSource("checkedLottos")
    void check(List<Lotto> lottoList, WinningLotto winningLotto, List<Integer> expected) {
        Lottos lottos = Lottos.of(lottoList);
        List<Integer> winningCounts = lottos.match(winningLotto);
        assertThat(winningCounts).isEqualTo(expected);
    }
}
