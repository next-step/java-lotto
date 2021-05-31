package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {

    @Test
    @DisplayName("입력한 개수만큼 로또를 생성한다.")
    void generateLotteries_test() {
        //when
        Lotteries lotteries = new Lotteries(new GenerateCount(5), new MockNumberGenerator());

        //then
        assertThat(lotteries.size()).isEqualTo(5);
    }
}
