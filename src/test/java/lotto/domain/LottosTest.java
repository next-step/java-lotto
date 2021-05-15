package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottosTest {

    static Stream<Arguments> lottoSource() {
        return Stream.of(arguments(
                Lists.list(
                        new Lotto(LottoBalls.createLottoBalls(1, 2, 3, 4, 5, 6)),
                        new Lotto(LottoBalls.createLottoBalls(2, 3, 4, 5, 6, 7))
                )
        ));
    }

    @Test
    @DisplayName("돈을 입력받은만큼 자동 로또로 교환하기")
    void create_auto_lottos() {
        Money money = Money.of(14000, 0);
        Lottos lottos = Lottos.of(money);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("수동 로또를 구매한 후 자동 로또를 추가하기")
    @MethodSource("lottoSource")
    void create_all_lottos(List<Lotto> lottoList) {
        Money money = Money.of(14000, 2);
        Lottos lottos = new Lottos(lottoList);

        lottos.addLottoList(Lottos.of(money).getLottos());

        assertThat(lottos.size()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 당첨 개수 확인")
    @MethodSource("lottoSource")
    void check(List<Lotto> lottoList) {
        Lottos lottos = new Lottos(lottoList);

        Set<Integer> lottoSet = IntStream.range(1, 7).boxed().collect(Collectors.toSet());

        assertThat(lottos.matchHit(WinningLotto.of(lottoSet, 15))).isNotNull();
    }
}
