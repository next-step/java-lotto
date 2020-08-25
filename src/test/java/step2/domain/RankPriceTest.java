package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class RankPriceTest {

    @Test
    @DisplayName("우승 금액 및 맞춘 숫자수")
    void getRankPrice() {
        assertThat(RankPrice.FIFTH_PLACE.getMatchNumber()).isEqualTo(3);
        assertThat(RankPrice.FIFTH_PLACE.getWinedMoney()).isEqualTo(5000);

        assertThat(RankPrice.FOURTH_PLACE.getMatchNumber()).isEqualTo(4);
        assertThat(RankPrice.FOURTH_PLACE.getWinedMoney()).isEqualTo(50000);

        assertThat(RankPrice.THIRD_PLACE.getMatchNumber()).isEqualTo(5);
        assertThat(RankPrice.THIRD_PLACE.getWinedMoney()).isEqualTo(1500000);

        assertThat(RankPrice.FIRST_PLACE.getMatchNumber()).isEqualTo(6);
        assertThat(RankPrice.FIRST_PLACE.getWinedMoney()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("예외 테스트")
    void valueOfTest() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            RankPrice.valueOf(7);
        });
    }
}