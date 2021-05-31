package lottery.domain;

import lottery.domain.Lottery;
import lottery.domain.LotteryNumbers;
import lottery.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteryTest {

    @Test
    @DisplayName("6개의 숫자와 1000원의 가격을 가지는 로또를 생성한다.")
    void generateLottery_test() {
        //given
        LotteryNumbers lotteryNumbers = new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lottery lottery = new Lottery(lotteryNumbers);

        //then
        assertAll(
                () -> assertThat(lottery.numbers()).isEqualTo(lotteryNumbers),
                () -> assertThat(lottery.price()).isEqualTo(new Price(1000))
        );
    }
}
