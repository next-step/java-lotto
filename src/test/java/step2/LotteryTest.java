package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    @DisplayName("로또 번호와 일치하는 숫자가 몇개인지 확인한다")
    void matchTest() {
        Set<LotteryNumber> lottoNumbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        );
        Lottery lotto = new Lottery(lottoNumbers);

        Set<LotteryNumber> numbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(2)
        );
        assertThat(lotto.match(numbers)).isEqualTo(2);
    }
}
