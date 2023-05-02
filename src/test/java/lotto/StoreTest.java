package lotto;

import lotto.domain.Lotto;
import lotto.domain.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    @ParameterizedTest
    @CsvSource(value = {"14000, 14", "3500, 3", "5000, 5"})
    @DisplayName("예산으로 로또 구매하기")
    public void purchaseTest(String budget, int expect) {
        Store store = new Store();
        List<Lotto> result = store.purchase(budget);

        assertThat(result.size()).isEqualTo(expect);
    }

}
