package lotto.domain;

import lotto.exception.BadNumOfManualLottosException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottosTest {

    private static final int LOTTO_PRICE = 1000;
    private final Lotto autoLotto = new Lotto(Arrays.asList(2, 3, 6, 5, 4, 1));
    private final Supplier<Lotto> autoSupplier = () -> autoLotto;
    private final int purchaseMoney = 3000;
    private final List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40)));
    private final Lottos lottos = new Lottos(purchaseMoney, manualLottos, autoSupplier);

    @Test
    void testToString() {
        assertThat(lottos.toString())
                .isEqualTo("[40, 41, 42, 43, 44, 45]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                );
    }

    @Test
    @DisplayName("5등 getResult 테스트")
    void getResult_fifth() {

        Lotto winningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        LottoNo bonus = LottoNoPool.getLottoNo(3);
        int numOfAutoLottos = lottos.getNumOfAutoLottos();

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIFTH, numOfAutoLottos);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        Result expected = new Result();
        for (Lotto manualLotto : manualLottos) {
            expected.increaseNumOfLotto(condition, manualLotto);
        }
        for (int i = 0; i < numOfAutoLottos; i++) {
            expected.increaseNumOfLotto(condition, autoLotto);
        }
        assertThat(lottos.getResult(condition))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("3등 getResult 테스트")
    void getResult_third() {

        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(8);
        int numOfAutoLottos = lottos.getNumOfAutoLottos();

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.THIRD, numOfAutoLottos);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        Result expected = new Result();
        for (Lotto manualLotto : manualLottos) {
            expected.increaseNumOfLotto(condition, manualLotto);
        }
        for (int i = 0; i < numOfAutoLottos; i++) {
            expected.increaseNumOfLotto(condition, autoLotto);
        }
        assertThat(lottos.getResult(condition))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 getResult 테스트")
    void getResult_second() {

        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(1);
        int numOfAutoLottos = lottos.getNumOfAutoLottos();

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.SECOND, numOfAutoLottos);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        Result expected = new Result();
        for (Lotto manualLotto : manualLottos) {
            expected.increaseNumOfLotto(condition, manualLotto);
        }
        for (int i = 0; i < numOfAutoLottos; i++) {
            expected.increaseNumOfLotto(condition, autoLotto);
        }
        assertThat(lottos.getResult(condition))
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 구입금액을 초과하면, BadNumOfManualLottosException  발생한다.")
    @CsvSource(value = {"900$1", "1500$2", "9500$10"}, delimiter = '$')
    void constructor_BadNumOfManualLottosException(int purchaseMoney, int numOfManualLottos) {
        List<Lotto> manualLottos = new LinkedList<>();
        Lotto manualLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        for (int i = 0; i < numOfManualLottos; i++) {
            manualLottos.add(manualLotto);
        }
        assertThatExceptionOfType(BadNumOfManualLottosException.class)
                .isThrownBy(() -> new Lottos(purchaseMoney, manualLottos, autoSupplier));
    }

    @ParameterizedTest
    @DisplayName("getPurchaseMoney 테스트")
    @ValueSource(ints = {2000, 3500, 11500})
    void getPurchaseMoney(int purchaseMoney) {
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(new Lottos(purchaseMoney, manualLottos, autoSupplier).getPurchaseMoney())
                .isEqualTo(new Money(purchaseMoney));
    }

    @Test
    @DisplayName("getNumOfManualLottos 테스트")
    void getNumOfManualLottos() {
        List<Lotto> manualLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        assertThat(new Lottos(9000, manualLottos, autoSupplier).getNumOfManualLottos())
                .isEqualTo(manualLottos.size());
    }

    @ParameterizedTest
    @DisplayName("getNumOfTotalLottos 테스트")
    @ValueSource(ints = {2000, 3500, 11500})
    void getNumOfTotalLottos(int purchaseMoney) {
        int expected = purchaseMoney / LOTTO_PRICE;
        int numOfManualLottos = 1;
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(new Lottos(purchaseMoney, manualLottos, autoSupplier).getNumOfTotalLottos())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("getNumOfAutoLottos 테스트")
    @ValueSource(ints = {8070, 12500, 32500})
    void getNumOfAutoLottos(int purchaseMoney) {
        List<Lotto> manualLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        int expected = (purchaseMoney / LOTTO_PRICE) - manualLottos.size();
        assertThat(new Lottos(purchaseMoney, manualLottos, autoSupplier).getNumOfAutoLottos())
                .isEqualTo(expected);
    }
}
