package step4.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitAmountTest {

    @BeforeEach
    void initData() {
        LottoStatusEnum.findByCount(2).addWinningCount();
        LottoStatusEnum.findByCount(5).addWinningCount();
    }

    @Test
    void 누적금액_테스트() {
        double total = LottoProfitAmount.runLottoProfitAmount();
        assertThat(3.0005E7).isEqualTo(total);
    }
}