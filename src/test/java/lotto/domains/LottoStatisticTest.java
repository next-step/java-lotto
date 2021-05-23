package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {
    @Test
    void add_테스트() {
        LottoStatistic lottoStatistic = new LottoStatistic();
        assertThat(lottoStatistic.count()).isEqualTo(0);
        assertThat(lottoStatistic.payout()).isEqualTo(0);
        lottoStatistic.add(3);
        assertThat(lottoStatistic.count()).isEqualTo(1);
        assertThat(lottoStatistic.payout()).isEqualTo(5000);

    }
}
