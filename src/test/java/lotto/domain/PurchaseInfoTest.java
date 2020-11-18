package lotto.domain;

import lotto.exception.BadManualLottosException;
import lotto.exception.BadNumOfManualLottosException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseInfoTest {

    private static final int LOTTO_PRICE = 1000;

    @ParameterizedTest
    @DisplayName("수동으로 구매할 로또 수가 구입금액을 초과하면, BadNumOfManualLottosException  발생한다.")
    @CsvSource(value = {"900$1", "1500$2", "9500$10"}, delimiter = '$')
    void constructor_BadNumOfManualLottosException(int purchaseMoney, int numOfManualLottos) {
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThatExceptionOfType(BadNumOfManualLottosException.class)
                .isThrownBy(() -> new PurchaseInfo(purchaseMoney, numOfManualLottos, manualLottos));
    }

    @Test
    @DisplayName("수동으로 구매할 로또 수와 실제 수동으로 구매한 로또수가 다르면, BadManualLottosException  발생한다.")
    void constructor_BadManualLottosException() {
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThatExceptionOfType(BadManualLottosException.class)
                .isThrownBy(() -> new PurchaseInfo(100000, 2, manualLottos));
    }

    @ParameterizedTest
    @DisplayName("getPurchaseMoney 테스트")
    @ValueSource(ints = {2000, 3500, 11500})
    void getPurchaseMoney(int purchaseMoney) {
        int numOfManualLottos = 1;
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(new PurchaseInfo(purchaseMoney, numOfManualLottos, manualLottos).getPurchaseMoney())
                .isEqualTo(new Money(purchaseMoney));
    }

    @Test
    @DisplayName("getNumOfManualLottos 테스트")
    void getNumOfManualLottos() {
        int numOfManualLottos = 5;
        List<Lotto> manualLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        assertThat(new PurchaseInfo(9000, numOfManualLottos, manualLottos).getNumOfManualLottos())
                .isEqualTo(numOfManualLottos);
    }

    @ParameterizedTest
    @DisplayName("getNumOfTotalLottos 테스트")
    @ValueSource(ints = {2000, 3500, 11500})
    void getNumOfTotalLottos(int purchaseMoney) {
        int expected = purchaseMoney / LOTTO_PRICE;
        int numOfManualLottos = 1;
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(new PurchaseInfo(purchaseMoney, numOfManualLottos, manualLottos).getNumOfTotalLottos())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("getNumOfAutoLottos 테스트")
    @ValueSource(ints = {8070, 12500, 32500})
    void getNumOfAutoLottos(int purchaseMoney) {
        int numOfManualLottos = 5;
        List<Lotto> manualLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        int expected = (purchaseMoney / LOTTO_PRICE) - numOfManualLottos;
        assertThat(new PurchaseInfo(purchaseMoney, numOfManualLottos, manualLottos).getNumOfAutoLottos())
                .isEqualTo(expected);
    }
}
