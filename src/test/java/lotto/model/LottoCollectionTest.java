package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCollectionTest {

    private LottoCollection buyLottos;
    private Lotto buyLotto1;

    @BeforeEach
    void setup() {
        buyLotto1 = toLottoNumber(List.of(3, 5, 10, 12, 16, 33));
        Lotto buyLotto2 = toLottoNumber(List.of(4, 6, 10, 11, 13, 18));
        Lotto buyLotto3 = toLottoNumber(List.of(7, 8, 14, 18, 19, 35));
        buyLottos = new LottoCollection(List.of(buyLotto1, buyLotto2, buyLotto3));
    }

    @Test
    @DisplayName("로또 구매개수가 0개면 예외를 던진다")
    void quantity() {
        List<Lotto> emptyList =new ArrayList<>();

        assertThatThrownBy(() -> {
            new LottoCollection(emptyList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("rankTest")
    @DisplayName("당첨번호의 등수를 등급으로 반환한다")
    void countRank(List<Integer> element, Rank expected) {
        Lotto winningLotto = toLottoNumber(element);
        assertThat(buyLotto1.matchingRank(winningLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("rankTest")
    @DisplayName("당첨번호의 등수를 리스트로 반환한다")
    void collectRank(List<Integer> element, Rank expected, Rank expected2) {
        Lotto winningLotto = toLottoNumber(element);
        EnumMap<Rank, Integer> map = new EnumMap<>(Rank.class);
        map.put(expected, 1);
        map.put(expected2, 2);

        assertThat(buyLottos.collectRanks(winningLotto)).isEqualTo(new MatchingRank(map));
    }

    private static Stream<Arguments> rankTest() {
        return Stream.of(
                Arguments.of(List.of(3, 5, 10, 12, 16, 33), ONE, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 12, 16, 36), THREE, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 12, 18, 36), FOUR, MISS, MISS)
        );
    }

    private Lotto toLottoNumber(List<Integer> testLotto) {
        return new Lotto(lottoNumbers(testLotto));
    }

    public static Set<LottoNumber> lottoNumbers(List<Integer> testLotto) {
        return testLotto.stream()
                .map(Integer -> LottoNumber.cache().get(Integer))
                .collect(Collectors.toSet());
    }
}