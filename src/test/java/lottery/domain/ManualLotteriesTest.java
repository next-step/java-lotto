package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLotteriesTest {

    public static final List<LotteryNumbers> TEST_LOTTERY_NUMBERS = List.of(
            new LotteryNumbers(List.of(10, 15, 24, 39, 40, 45)),
            new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6))
    );

    @Test
    @DisplayName("수동 로또를 입력한 숫자로 생성한다.")
    void generateManualLotteries_test() {
        //when
        ManualLotteries manualLotteries = new ManualLotteries(TEST_LOTTERY_NUMBERS);

        //then
        assertThat(manualLotteries.size()).isEqualTo(2);
    }
}
