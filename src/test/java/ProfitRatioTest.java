import domain.LottoResult;
import domain.Money;
import domain.Rank;
import org.junit.Test;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRatioTest {
    @Test
    public void 수익률계산() {
        int money = 14000;
        Rank value = Rank.valueOf("FIFTH");
        LottoResult list = new LottoResult();
        list.addLotto(value);
        int sum = 0;
        for(Map.Entry<Rank, Integer> entry : list.entrySet()) {
            Rank rank = entry.getKey();
            Integer integer = entry.getValue();
            sum += Money.sum(rank, integer);
        }
        double totalProfit = Money.profitRatio(money, sum);
        assertThat(totalProfit).isEqualTo(0.36);
    }
}
