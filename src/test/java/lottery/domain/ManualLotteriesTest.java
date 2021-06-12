package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLotteriesTest {

    @Test
    @DisplayName("수동 로또를 입력한 숫자로 생성한다.")
    void generateManualLotteries_test() {
        //given
        List<LotteryNumbers> lotteryNumbers = List.of(
                new LotteryNumbers(List.of(10, 15, 24, 39, 40, 45)),
                new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6))
        );

        //when
        ManualLotteries manualLotteries = new ManualLotteries(lotteryNumbers);

        //then
        assertThat(manualLotteries.size()).isEqualTo(2);
    }
}
