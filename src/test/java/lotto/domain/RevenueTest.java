package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueTest {
    @Test
    void 수익률_계산() {
        Revenue revenue = new Revenue();
        assertThat(revenue.calculateRevenue(10000, 3000)).isEqualTo(0.3);
    }

    @Test
    void 총수익() {
        Revenue revenue = new Revenue();
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1,2,3,7,8,9)),
                        new Lotto(List.of(1,2,3,4,8,9)),
                        new Lotto(List.of(1,2,3,4,5,6))
                )
        );
        List<Integer> winNumbers = new Winning().createWinNumbers("1,2,3,4,5,6");
        assertThat(revenue.getRevenueTotal(LottoMatch.match(lottos, winNumbers))).isEqualTo(2000055000);
    }
}
