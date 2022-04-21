package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {
    @ParameterizedTest
    @CsvSource({"5000,5", "1500,1", "600,0"})
    void 구매_개수_테스트(int price, int count) {
        Store store = new Store();
        assertThat(store.countOfLottos(price)).isEqualTo(count);
    }
}