package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMatcherTest {

    @DisplayName("인스턴스가 잘 생성되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createLottoMatcher")
    void createInstance(Lottos lottos, LastWeekLotto lastWeekLotto) {
        //given
        LottoMatcher lottoMatcher = LottoMatcher.ofMatch(lottos, lastWeekLotto);

        //then
        assertThat(lottoMatcher).isEqualTo(LottoMatcher.ofMatch(lottos, lastWeekLotto));
    }

    private static Stream<Arguments> createLottoMatcher() {
        return Stream.of(
                Arguments.of(
                        new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7))),
                Arguments.of(
                        new Lottos(Collections.singletonList(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)), new LottoNumber(7))),
                Arguments.of(
                        new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26)), new LottoNumber(7)))
        );
    }

    @DisplayName("로또 매칭할때 맞는 갯수만큼 비율이 나오는지 확인을 한다.")
    @ParameterizedTest
    @MethodSource("createLottoMatcherRank")
    void sumLottoMatchPrize(Lottos lottos, LastWeekLotto lastWeekLotto, double expectedRatio) {
        //given
        LottoMatcher lottoMatcher = LottoMatcher.ofMatch(lottos, lastWeekLotto);
        //when
        double lottoRatio = lottoMatcher.getLottoRatio(new GameMoney(1000));
        //then
        System.out.println("lottoRatio = " + lottoRatio);
        assertThat(lottoRatio).isEqualTo(expectedRatio);
    }

    private static Stream<Arguments> createLottoMatcherRank() {
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(45)), 2000000.0),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), new LottoNumber(6)), 30000.0),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), new LottoNumber(45)), 1500.0),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), new LottoNumber(45)), 50.0),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), new LottoNumber(45)), 5.0));
    }


}
