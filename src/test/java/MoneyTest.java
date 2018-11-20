import domain.LottoResult;
import domain.Money;
import domain.Rank;
import org.junit.Test;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void 총당첨금계산() {
        Rank value = Rank.valueOf("FIFTH");
        Rank value2 = Rank.valueOf("FIFTH");
        LottoResult list = new LottoResult();
        list.addLotto(value);
        list.addLotto(value2);
        int sum = 0;
        for(Map.Entry<Rank, Integer> entry : list.entrySet()) {
            Rank rank = entry.getKey();
            Integer integer = entry.getValue();
            sum += Money.sum(rank, integer);
        }
        assertThat(sum).isEqualTo(10000);
    }
}
