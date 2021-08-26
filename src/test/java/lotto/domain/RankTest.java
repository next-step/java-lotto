package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("당첨 번호와 일치하는 갯수에 해당하는 당첨정보 리턴")
    @ParameterizedTest
    @CsvSource(value = {"3:FIFTH", "4:FOURTH", "5:SECOND", "6:FIRST", "0:NONE"}, delimiter = ':')
    void find(int matchCount, String expected) {
        boolean defaultMatchBonus = true;
        Rank matchedRank = Rank.find(matchCount, defaultMatchBonus);

        assertThat(matchedRank).isEqualTo(Rank.valueOf(expected));
    }

    @DisplayName("당첨 정보에 해당하는 카운트를 세기 위한 맵 생성")
    @ParameterizedTest
    @CsvSource(value = {"FIFTH:true", "FOURTH:true", "THIRD:true", "SECOND:true", "FIRST:true", "NONE:true"}, delimiter = ':')
    void makeWinnerMap(String winnerName, boolean expected) {
        Map<Rank, Integer> winnerMap = Rank.makeEmptyRankMap();
        Rank inputRank = Rank.valueOf(winnerName);
        assertThat(winnerMap.containsKey(inputRank)).isEqualTo(expected);
    }
}