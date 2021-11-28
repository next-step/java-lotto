package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
