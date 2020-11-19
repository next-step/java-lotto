package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private final Lotto dummyLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    private final Supplier<Lotto> dummySupplier = () -> dummyLotto;
    private final PurchaseInfo info = new PurchaseInfo(
            3000,
            0,
            Collections.emptyList()
    );

    @Test
    void testToString() {
        assertThat(new Lottos(info, dummySupplier).toString())
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

        int numOfAutoLottos = info.getNumOfAutoLottos();
        Lottos lottos = new Lottos(info, dummySupplier);

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIFTH, numOfAutoLottos);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        Result expected = new Result();
        for (int i = 0; i < numOfAutoLottos; i++) {
            expected.increaseNumOfLotto(condition, dummyLotto);
        }
        assertThat(lottos.getResult(condition))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("3등 getResult 테스트")
    void getResult_third() {

        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(8);

        int numOfAutoLottos = info.getNumOfAutoLottos();
        Lottos lottos = new Lottos(info, dummySupplier);

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.THIRD, numOfAutoLottos);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        Result expected = new Result();
        for (int i = 0; i < numOfAutoLottos; i++) {
            expected.increaseNumOfLotto(condition, dummyLotto);
        }
        assertThat(lottos.getResult(condition))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 getResult 테스트")
    void getResult_second() {

        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(1);

        int numOfAutoLottos = info.getNumOfAutoLottos();
        Lottos lottos = new Lottos(info, dummySupplier);

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.SECOND, numOfAutoLottos);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        Result expected = new Result();
        for (int i = 0; i < numOfAutoLottos; i++) {
            expected.increaseNumOfLotto(condition, dummyLotto);
        }
        assertThat(lottos.getResult(condition))
                .isEqualTo(expected);
    }
}
