package lottery;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumbersGeneratorTest {

    @DisplayName("6개의 번호를 지닌 LotteryNumbers 리스트 반환 테스트")
    @Test
    public void generateLotteryNumbersAutomatic() {
        List<LotteryNumber> lotteryNumbers = LotteryNumbersGenerator.generateAutomatic();

        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }
}
