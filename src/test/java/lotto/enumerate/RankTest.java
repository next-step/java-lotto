package lotto.enumerate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class RankTest {
    @ParameterizedTest
    @DisplayName("로또 숫자와 보너스 볼의 매칭 결과에 따라 올바른 Enum 을 반환하는지 테스트")
    @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH", "3:false:FIFTH"}, delimiter = ':')
    public void valueOfTest(int countOfMatch, boolean matchBonus, Rank rank){
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(rank);
    }
}