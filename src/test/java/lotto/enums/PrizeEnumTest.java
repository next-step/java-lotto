package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeEnumTest {
    @Test
    @DisplayName("일치하는 로또 개수 반환")
    void getPrize() {
        //given
        //when
        PrizeEnum prizeEnum = PrizeEnum.valueOf(3, false);
        //then
        assertThat(prizeEnum.prize()).isEqualTo(PrizeEnum.FIFTH.prize());
    }

    @Test
    @DisplayName("2등 결과 확인")
    void getSecondPrize() {
        //given
        //when
        PrizeEnum prizeEnum = PrizeEnum.valueOf(5, true);
        //then
        assertThat(prizeEnum.prize()).isEqualTo(PrizeEnum.SECOND.prize());
    }

    @Test
    @DisplayName("3등 결과 확인")
    void getThirdPrize() {
        //given
        //when
        PrizeEnum prizeEnum = PrizeEnum.valueOf(5, false);
        //then
        assertThat(prizeEnum.prize()).isEqualTo(PrizeEnum.THIRD.prize());
    }
}