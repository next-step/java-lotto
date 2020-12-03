package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    @DisplayName("List<Rank>를 Map형태로 변환한다.")
    void should_convert_map() {
        //Given
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIRST, Rank.SECOND));

        //When
        Map<Rank, Integer> rankIntegerMap = ranks.convertToMap();

        //Then
        assertThat(rankIntegerMap).containsKeys(Rank.FIRST, Rank.SECOND);
    }

    @Test
    @DisplayName("Ranks의 당첨금의 합을 구한다.")
    void should_return_all_of_prize_money() {
        //Given
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIRST, Rank.SECOND));
        double expectedPrizeMoney = Rank.FIRST.getPrizeMoney() + Rank.SECOND.getPrizeMoney();

        //When
        double allPrizeMoney = ranks.getAllPrizeMoney();

        //Then
        assertThat(allPrizeMoney).isEqualTo(expectedPrizeMoney);
    }

}
