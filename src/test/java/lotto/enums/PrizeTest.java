package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @DisplayName("일치하는 로또 개수 반환")
    void getPrize() {
        //given
        //when
        Prize prize = Prize.valueOf(3, false);
        //then
        assertThat(prize.money()).isEqualTo(Prize.FIFTH.money());
    }

    @Test
    @DisplayName("2등 결과 확인")
    void getSecondPrize() {
        //given
        //when
        Prize prize = Prize.valueOf(5, true);
        //then
        assertThat(prize.money()).isEqualTo(Prize.SECOND.money());
    }

    @Test
    @DisplayName("3등 결과 확인")
    void getThirdPrize() {
        //given
        //when
        Prize prize = Prize.valueOf(5, false);
        //then
        assertThat(prize.money()).isEqualTo(Prize.THIRD.money());
    }
}