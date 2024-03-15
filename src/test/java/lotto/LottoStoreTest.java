package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(
        value = {"0:0", "999:0", "1000:1", "1999:1", "2000:2", "2999:2", "3000:3"},
        delimiter = ':'
    )
    @DisplayName("가진 돈에 따라 최대한 많은 로또를 판매한다")
    void purchaseAsMuchAsPossible(int input, int expected) {
        Money money = new Money(input);

        List<Lotto> lotto = LottoStore.sellAsMuchAsPossible(money);
        assertThat(lotto).hasSize(expected);

        int change = input - (1000 * expected);
        assertThat(money.amount()).isEqualTo(change);
    }
}
