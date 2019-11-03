package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    // double 은 정확한 테스트를 진행할 수 없다. 더 좋은 접근 방법이 없을까?
    @Test
    void profitRateTest() {
        Map<LottoRank, Long> rankGroup = new HashMap<LottoRank, Long>() {{
            put(LottoRank.THIRD, 1L);
        }};

        Money tenThousand = new Money(10000);
        assertThat((long) (tenThousand.getProfitRate(rankGroup) * 100)).isEqualTo(500);
    }
}
