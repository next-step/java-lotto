package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinStatisticTest {

    WinStatistic mockEmptyStatistic;
    WinStatistic mockFullStatistic;

    @BeforeEach
    void setUp() {
        mockFullStatistic = new WinStatistic(3, 2, 5000);
    }

    @DisplayName("생성된 객체가 빈 값인지 확인")
    @Test
    void isEmpty() {
        mockEmptyStatistic = new WinStatistic();

        assertThat(mockEmptyStatistic.isEmpty())
                .isTrue();
    }

    @DisplayName("일치하는 숫자의 로또 갯수를 1 올리기")
    @Test
    void increaseCount() {
        mockFullStatistic.increaseCount();

        assertThat(mockFullStatistic.getCount())
                .isEqualTo(3);
    }

    @DisplayName("당첨된 로또 횟수와 가격을 곱해서 반환")
    @Test
    void getPrizeAmount() {
        assertThat(mockFullStatistic.getPrizeAmount(mockFullStatistic))
                .isEqualTo(10000);
    }
}