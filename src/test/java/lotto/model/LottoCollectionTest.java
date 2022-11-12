package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;
import java.util.stream.Stream;

import static lotto.model.Lotto.toLottoNumber;
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
        assertThat(buyLotto1.countRank(winningLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("rankTest")
    @DisplayName("당첨번호의 등수를 리스트로 반환한다")
    void collectRank(List<Integer> element, Rank expected, Rank expected2, Rank expected3) {
        Lotto winningLotto = toLottoNumber(element);
        assertThat(buyLottos.collectRanks(winningLotto)).containsExactly(expected, expected2, expected3);
    }

    private static Stream<Arguments> rankTest() {
        return Stream.of(
                Arguments.of(List.of(3, 5, 10, 12, 16, 33), ONE, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 12, 16, 36), THREE, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 12, 18, 36), FOUR, MISS, MISS),
                Arguments.of(List.of(3, 5, 10, 11, 18, 36), FIVE, FIVE, MISS),
                Arguments.of(List.of(3, 5, 7, 13, 18, 36), MISS, MISS, MISS)
        );
    }
}