package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private final Supplier<Lotto> dummySupplier = () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void testToString() {
        int size = 3;
        assertThat(new Lottos(size, dummySupplier).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                );
    }

    @ParameterizedTest
    @DisplayName("getResult 가 제대로 계산되어야한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void getResult(int countOfMatch) {
        int lottoSize = 6;
        Integer[] winningLotoNos = new Integer[lottoSize];
        for (int i = 0; i < lottoSize; i++) {
            winningLotoNos[i] = i + 1 + lottoSize - countOfMatch;
        }

        Lotto winningLotto = new Lotto(Arrays.asList(winningLotoNos));
        LottoNo goodBonus = new LottoNo(6);
        LottoNo badBonus = new LottoNo(45);

        int numOfLottos = 3;
        Lottos lottos = new Lottos(numOfLottos, dummySupplier);

        Map<Rank, Integer> goodResult = new HashMap<>();
        Map<Rank, Integer> badResult = new HashMap<>();

        Arrays.stream(Rank.values())
                .filter(rank -> rank == Rank.valueOf(countOfMatch, true))
                .forEach(rank -> {
                    goodResult.put(rank, numOfLottos);
                });
        Arrays.stream(Rank.values())
                .filter(rank -> rank == Rank.valueOf(countOfMatch, false))
                .forEach(rank -> {
                    badResult.put(rank, numOfLottos);
                });

        Assertions.assertAll(
                () -> assertThat(lottos.getResult(winningLotto, goodBonus))
                        .isEqualTo(new Result(goodResult)),
                () -> assertThat(lottos.getResult(winningLotto, badBonus))
                        .isEqualTo(new Result(badResult))
        );
    }
}
