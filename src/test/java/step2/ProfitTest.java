package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    @Test
    @DisplayName("수익률 구현 테스트")
    void profit_test(){
        String winningNumbers = "1,2,3,4,5,6";
        String purchasedNumbers1 = "1,2,3,4,44,45";
        String purchasedNumbers2="1,2,3,4,44,45";
        String purchasedNumbers3="1,2,3,43,44,45";

        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        LottoNumberGenerator generator = () ->
                Arrays.asList(new Lotto(purchasedNumbers1),new Lotto(purchasedNumbers2),new Lotto(purchasedNumbers3));
        Lottos lottos = Lottos.of(generator);

        Rank rank = lottos.makeStatistic(winningLotto);
        PurchaseManager manager = new PurchaseManager(new Money(3000));
        Profit profit = new Profit(manager,rank);

        assertThat(profit.profitRate()).isEqualTo(35.0);
    }
}
