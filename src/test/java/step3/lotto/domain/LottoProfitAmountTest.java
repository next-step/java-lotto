package step3.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitAmountTest {

    static{
        LottoStatusEnum.findByCount(1).addWinningCount();
        LottoStatusEnum.findByCount(2).addWinningCount();
        LottoStatusEnum.findByCount(3).addWinningCount();
        LottoStatusEnum.findByCount(4).addWinningCount();
        LottoStatusEnum.findByCount(5).addWinningCount();
    }

    @Test
    void 누적금액_테스트(){
        double total = LottoProfitAmount.runLottoProfitAmount();

        assertThat(2.03155E9).isEqualTo(total);
    }
}
