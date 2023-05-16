package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryPlaceTest {
    @Test
    void matchCountToLotteryPlaceNoBonusHit() {
        var matchCnt = new Natural(5);
        var bonusHit = false;

        var place = LotteryPlace.fromMatchCnt(matchCnt, bonusHit);

        assertThat(place).isEqualTo(LotteryPlace.THIRD);
    }

    @Test
    void matchCountToLotteryPlaceBonusHit() {
        var matchCnt = new Natural(5);
        var bonusHit = true;

        var place = LotteryPlace.fromMatchCnt(matchCnt, bonusHit);

        assertThat(place).isEqualTo(LotteryPlace.SECOND);
    }

    @Test
    void matchCountToLotteryPlaceMiss() {
        var matchCnt = new Natural(2);
        var bonusHit = true;

        var place = LotteryPlace.fromMatchCnt(matchCnt, bonusHit);

        assertThat(place).isEqualTo(LotteryPlace.MISS);
    }
}
