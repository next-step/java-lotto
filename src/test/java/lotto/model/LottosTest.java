package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;
import java.util.stream.Stream;

import static lotto.model.LottoNumber.toLottoNumberSet;
import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    private Lottos buyLottos;
    private Lotto buyLotto1;

    @BeforeEach
    void setup() {
        buyLotto1 = toLottoNumber(List.of(3, 5, 10, 12, 16, 33));
        Lotto buyLotto2 = toLottoNumber(List.of(4, 6, 10, 11, 13, 18));
        Lotto buyLotto3 = toLottoNumber(List.of(7, 8, 14, 18, 19, 35));
        buyLottos = new Lottos(List.of(buyLotto1, buyLotto2, buyLotto3));

    }

    @Test
    @DisplayName("로또 구매개수가 0개면 예외를 던진다")
    void quantity() {
        List<Lotto> emptyList =new ArrayList<>();

        assertThatThrownBy(() -> {
            new Lottos(emptyList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("rankTest")
    @DisplayName("당첨번호의 등수를 등급으로 반환한다")
    void countRank(List<Integer> element, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(toLottoNumber((element)),
                LottoNumber.lottoNumber(45));

        assertThat(buyLotto1.rank(winningLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("rankTest")
    @DisplayName("당첨번호의 등수를 리스트로 반환한다")
    void collectRank(List<Integer> element, Rank expected, Rank expected2) {
        WinningLotto winningLotto = new WinningLotto(toLottoNumber((element)),
                LottoNumber.lottoNumber(45));


        EnumMap<Rank, Integer> map = new EnumMap<>(Rank.class);
        map.put(expected, 1);
        map.put(expected2, 2);

        assertThat(buyLottos.collectRanks(winningLotto)).isEqualTo(new RankGroup(map));
    }

    private static Stream<Arguments> rankTest() {
        return Stream.of(
                Arguments.of(List.of(3, 5, 10, 12, 16, 33), ONE, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 12, 16, 36), THREE, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 12, 18, 36), FOUR, MISS, MISS)
        );
    }

    private Lotto toLottoNumber(List<Integer> testLotto) {
        return new Lotto(toLottoNumberSet(testLotto));
    }
}