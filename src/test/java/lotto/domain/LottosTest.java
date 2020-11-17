package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


    @Test
    @DisplayName("5등 getResult 테스트")
    void getResult_fifth() {

        Lotto winningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        LottoNo bonus = LottoNoPool.getLottoNo(3);

        int numOfLottos = 3;
        Lottos lottos = new Lottos(numOfLottos, dummySupplier);

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIFTH, numOfLottos);

        assertThat(lottos.getResult(winningLotto, bonus))
                .isEqualTo(new Result(result));
    }

    @Test
    @DisplayName("3등 getResult 테스트")
    void getResult_third() {

        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(8);

        int numOfLottos = 3;
        Lottos lottos = new Lottos(numOfLottos, dummySupplier);

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.THIRD, numOfLottos);

        assertThat(lottos.getResult(winningLotto, bonus))
                .isEqualTo(new Result(result));
    }

    @Test
    @DisplayName("2등 getResult 테스트")
    void getResult_second() {

        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(1);

        int numOfLottos = 3;
        Lottos lottos = new Lottos(numOfLottos, dummySupplier);

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.SECOND, numOfLottos);

        assertThat(lottos.getResult(winningLotto, bonus))
                .isEqualTo(new Result(result));
    }
}
