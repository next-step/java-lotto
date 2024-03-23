package lotto;

import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH", "3:false:FIFTH", "0:false:MISS"}
                , delimiter = ':')
    @DisplayName("[성공] 당첨 번호 개수에 해당되는 로또 등수를 반환한다.")
    void 로또_등수(int matchCount, boolean matchBonus, Rank rank) {
        Assertions.assertThat(Rank.valueOf(matchCount, matchBonus)).isEqualTo(rank);
    }
    
}
