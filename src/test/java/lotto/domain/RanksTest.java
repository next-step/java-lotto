package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.Rank.FIFTH_RANK;
import static lotto.enums.Rank.FIRST_RANK;
import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    void 총_당첨금액_반환() {
        Ranks ranks = new Ranks(List.of(FIFTH_RANK, FIFTH_RANK, FIRST_RANK));
        assertThat(ranks.getPriceTotal()).isEqualTo(2000010000L);
    }

    @Test
    @DisplayName("등수에 해당하는 수를 반환한다.")
    void 등수_반환() {
        Ranks ranks = new Ranks(List.of(FIFTH_RANK, FIFTH_RANK, FIRST_RANK));
        assertThat(ranks.getWinnerCount(FIFTH_RANK)).isEqualTo(2);
    }

}
