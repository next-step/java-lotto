package lottery_auto;

import lottery_auto.strategy.LotteryStrategy;
import lottery_auto.strategy.LotteryStrategyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStrategyTest {
    private LotteryStrategy lotteryStrategy = new LotteryStrategyImpl();

    @Test
    @DisplayName("사이즈가 6인 로또숫자 리스트 생성 테스트")
    void generate() {
        List<Integer> numberList = lotteryStrategy.generate();
        assertThat(numberList.size()).isEqualTo(6);
    }

}