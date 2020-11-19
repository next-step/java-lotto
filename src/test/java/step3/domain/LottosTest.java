package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.LottoRank;
import step3.domain.LastWeekLotto;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.Lottos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {


    @DisplayName("로또의 갯수들이 로또티켓들의 갯수에 맞게 생성되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createLotto")
    void create(Lotto lotto1, Lotto lotto2, Lotto lotto3) {
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
        assertThat(lottos.getLottoCount()).isEqualTo(3);
    }

    @DisplayName("로또 생성뒤 반환되는 문자열이 맞는지 확인을 한다.")
    @ParameterizedTest
    @MethodSource("createSingleLotto")
    void createLottosToString(Lotto lotto1, Lotto lotto2, Lotto lotto3) {
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
        assertThat(lottos.lottoNumbersToStringList()).containsExactly(
                "1, 2, 3, 4, 5, 6",
                "1, 2, 3, 4, 5, 7",
                "1, 2, 3, 4, 5, 8");
    }

    @DisplayName("로또들이 생성될때 맞게 생성되는지 확인한다..")
    @ParameterizedTest
    @MethodSource("createLotto")
    void createLottoInstance(Lotto lotto1, Lotto lotto2, Lotto lotto3) {
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(lotto1, lotto2, lotto3)));
    }

    @DisplayName("지난주에 맞췄던 로또들의 맞춘 갯수들을 검증한다.")
    @ParameterizedTest
    @MethodSource("createMatchLotto")
    void validateMatchLottos(Lotto lotto, LastWeekLotto lastWeekLotto, LottoRank expected) {
        Lottos lottos = new Lottos(Collections.singletonList(lotto));
        assertThat(lottos.matchLastWeekLotto(lastWeekLotto)).contains(expected);
    }

    private static Stream<Arguments> createSingleLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))));
    }

    private static Stream<Arguments> createLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))),
                Arguments.of(
                        new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                        new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)),
                        new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11))));
    }


    private static Stream<Arguments> createMatchLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(45)),
                        LottoRank.FIRST),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), new LottoNumber(6)),
                        LottoRank.SECOND),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), new LottoNumber(45)),
                        LottoRank.THIRD),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), new LottoNumber(45)),
                        LottoRank.FORTH),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), new LottoNumber(45)),
                        LottoRank.FIFTH)

        );
    }

}
