package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

    @DisplayName("입력한 금액 만큼의 로또가 생성되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"500:0", "1000:1", "14000:14"}, delimiter = ':')
    void lottiesCount(int value, int gameCount) {
        Money money = new Money(value);
        LottoGenerator numberGenerator = new RandomLottoGenerator();
        Store store = new Store();
        Lotties lotties = store.purchaseLottiesByMoney(money, numberGenerator);

        assertThat(lotties.purchaseLottiesCount()).isEqualTo(gameCount);
    }

    @DisplayName("수동으로 입력한 로또 구매 테스트")
    @Test
    void purchaseManualLotto() {
        List<String> lottoPaper = Arrays.asList("2, 9, 13, 33 ,39, 45", "34, 40, 13, 2 ,9, 44");
        Store store = new Store();
        Lotties lotties = store.purchaseManualLotto(lottoPaper);

        assertThat(lotties.purchaseLottiesCount()).isEqualTo(2);
    }
}
