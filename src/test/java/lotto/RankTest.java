package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("번호 일치개수와 보너스볼 여부에 따라 정확한 등수를 리턴하는지 확인한다")
    @ParameterizedTest(name = "{displayName} ==> count : {0}, bonusMatch : {1} / result : {2}")
    @CsvSource({"5, true, SECOND", "5,false,THIRD", "6,false,FIRST", "6,true,ELSE", "3,false,FIFTH"})
    void check_rank_based_on_count_and_bonusMatch(int matchCount, boolean matchBonus, Rank result) {
        //Given + When + Then
        assertThat(Rank.valueOf(matchCount, matchBonus)).isEqualTo(result);
    }
}
