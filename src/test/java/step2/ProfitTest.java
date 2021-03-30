package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    @Test
    @DisplayName("수익률 구현 테스트")
    void profit_test() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers2 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers3 = new InputNumber("1,2,3,43,44,45");

        WinningLotto winningLotto = new WinningLotto(winningNumbers.numbers());
        LottoNumberGenerator generator = () ->
                Arrays.asList(new Lotto(purchasedNumbers1.numbers()),
                        new Lotto(purchasedNumbers2.numbers()), new Lotto(purchasedNumbers3.numbers()));
        Lottos lottos = Lottos.of(generator);

        Rank rank = lottos.makeStatistic(winningLotto);
        PurchaseManager manager = new PurchaseManager(new Money(3000));
        Profit profit = new Profit(manager, rank);

        assertThat(profit.profitRate()).isEqualTo(35.0);
    }
}
