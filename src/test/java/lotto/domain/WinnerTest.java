package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @DisplayName("당첨 번호와 일치하는 갯수에 해당하는 당첨정보 리턴")
    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH", "4:THIRD", "5:SECOND", "6:FIRST", "0:NONE"}, delimiter = ':')
    void find(int matchCount, String expected) {
        Winner matchedWinner = Winner.find(matchCount);

        assertThat(matchedWinner).isEqualTo(Winner.valueOf(expected));
    }

    @DisplayName("당첨 정보에 해당하는 카운트를 세기 위한 맵 생성")
    @ParameterizedTest
    @CsvSource(value = {"FOURTH:true", "THIRD:true", "SECOND:true", "FIRST:true", "NONE:false"}, delimiter = ':')
    void makeWinnerMap(String winnerName, boolean expected) {
        Map<Winner, Integer> winnerMap = Winner.makeWinnerMap();
        Winner inputWinner = Winner.valueOf(winnerName);
        assertThat(winnerMap.containsKey(inputWinner)).isEqualTo(expected);
    }
}