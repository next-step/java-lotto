package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;

import static lotto.model.Lotto.toLottoNumber;
import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCollectionTest {

    private LottoCollection buyLottos;
    private final EnumMap<Rank, Integer> winningMatch = new EnumMap<>(Rank.class);
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
    @DisplayName("당첨번호의 등수를 반환한다")
    void winningRank(List<Integer> element, Rank expected) {
        Lotto winningLotto = toLottoNumber(element);
        assertThat(buyLotto1.countRank(winningLotto)).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨번호의 등수, 개수를 담은 EnumMap을 반환한다")
    void rank() {
        Lotto winningLotto = toLottoNumber(List.of(3, 5, 10, 12, 18, 36));
        winningMatch.put(MISS, 2);
        winningMatch.put(FOUR, 1);

        assertThat(buyLottos.match(winningLotto)).isEqualTo(new MatchingCollection(winningMatch));
    }

    private static Stream<Arguments> rankTest() {
        return Stream.of(
                Arguments.of(List.of(3, 5, 10, 12, 16, 33), SIX),
                Arguments.of(List.of(3, 5, 10, 12, 16, 36), FIVE),
                Arguments.of(List.of(3, 5, 10, 12, 18, 36), FOUR),
                Arguments.of(List.of(3, 5, 10, 11, 18, 36), THREE),
                Arguments.of(List.of(3, 5, 7, 13, 18, 36), MISS)
        );
    }
}