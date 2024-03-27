package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void lotteryNumbersTest(){
        // Given
        final Lottery lottery = new Lottery("1, 2, 3, 4, 5, 6");

        // When
        Set<Integer> actual = lottery.lotteryNumbers();

        // Then
        assertThat(actual).hasSize(6);
        assertThat(actual).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호 일치 개수 테스트")
    void matchNumbersCountTest() {
        // Given
        final Lottery lottery = new Lottery("1, 2, 3, 4, 5, 6");
        final Lottery otherLottery = new Lottery("3, 4, 5, 6, 7, 8");

        // When
        Long actual = lottery.matchNumbersCount(otherLottery);

        // Then
        Long expected = 4L;
        assertThat(actual).isEqualTo(expected);
    }
}
