package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMatcherTest {

    @DisplayName("인스턴스가 잘 생성되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createLottoMatcher")
    void createInstance(Lottos lottos, List<Integer> lastWeekLotto) {
        assertThat(LottoMatcher.ofMatch(lottos , lastWeekLotto)).isEqualTo(LottoMatcher.ofMatch(lottos,lastWeekLotto));
    }

    private static Stream<Arguments> createLottoMatcher() {
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 매칭할때 맞는 갯수만큼 돈이 잘 합산되는지 확인을 한다.")
    @ParameterizedTest
    @MethodSource("createLottoMatcherRank")
    void createLottosToString(Lottos lottos, List<Integer> lastWeekLotto , GameMoney gameMoney) {
        assertThat(LottoMatcher.ofMatch(lottos , lastWeekLotto).getGamePrize()).isEqualTo(gameMoney);
    }
    private static Stream<Arguments> createLottoMatcherRank() {
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Arrays.asList(1, 2, 3, 4, 5, 6) , new GameMoney(LottoRank.FIRST.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Arrays.asList(1, 2, 3, 4, 5, 7) , new GameMoney(LottoRank.SECOND.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Arrays.asList(1, 2, 3, 4, 7, 8) , new GameMoney(LottoRank.THIRD.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Arrays.asList(1, 2, 3, 7, 8, 9) , new GameMoney(LottoRank.FORTH.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Arrays.asList(7, 8, 9, 10, 11, 12) , new GameMoney(LottoRank.MISS.getPrice())));
    }


}
