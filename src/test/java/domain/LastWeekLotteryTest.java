package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

class LastWeekLotteryTest {
    LastWeekLottery lastWeekLottery;

    @BeforeEach
    public void setup() {
        lastWeekLottery = new LastWeekLottery(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("전 주 로또 당첨번호 생성")
    public void createLastWeekLotteryNumber() {
        assertThat(lastWeekLottery.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨번호 중복확인")
    public void checkLotteryNumberOverlap() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LastWeekLottery(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5)));

            fail("로또번호 에러가 발생해야 한다.");
        });
    }

    @Test
    @DisplayName("5 ~ 9 까지 번호중 당첨번호가 2개 나와야 한다.")
    public void checkWinningNumber() {
        int count = 0;
        for (int i = 5; i <= 9; i++) {
            count += lastWeekLottery.matchNumber(i);
        }
        assertThat(count).isEqualTo(2);
    }
}
