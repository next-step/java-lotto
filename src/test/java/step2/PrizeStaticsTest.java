package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.PrizeStatics;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 일치하는 Prize가 없을 시 새로 생성한다.
- 일치하는 Prize가 있을 시 카운트를 올린다.
- matchCount가 일치한 로또 개수를 가져온다.
- 수익률을 가져온다.
*/
public class PrizeStaticsTest {

    @DisplayName("일치하는 Prize가 없을 시 새로 생성한다.")
    @Test
    void checkStaticsTest() {
        PrizeStatics prizeStatics = new PrizeStatics();
        prizeStatics.prize(3);

        assertThat(prizeStatics.getPrizes().get(3)).isEqualTo(1);
    }

    @DisplayName("일치하는 Prize가 있을 시 카운트를 올린다.")
    @Test
    void checkStaticsAddCountTest() {
        PrizeStatics prizeStatics = new PrizeStatics();
        prizeStatics.prize(3);
        prizeStatics.prize(3);

        assertThat(prizeStatics.getPrizes().get(3)).isEqualTo(2);
    }

    @DisplayName("matchCount가 일치한 로또 개수를 가져온다.")
    @Test
    void getPrizeCountTest() {
        PrizeStatics prizeStatics = new PrizeStatics();
        prizeStatics.prize(3);
        prizeStatics.prize(3);

        assertThat(prizeStatics.getPrize(3)).isEqualTo(2);
    }
}
