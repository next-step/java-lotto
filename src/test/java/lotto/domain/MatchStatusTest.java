package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchStatusTest {


    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false",
            "5:false", "5:true", "6:false"}, delimiter = ':')
    public void createInstanceTest(int matchCount, boolean isBonusball) {
        //Given & When
        MatchStatus matchStatus = new MatchStatus(matchCount, isBonusball);

        //Then
        assertThat(matchStatus).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false",
            "5:false", "5:true", "6:false"}, delimiter = ':')
    public void equalsTest(int matchCount, boolean isBonusball) {
        //Given
        MatchStatus matchStatus = new MatchStatus(matchCount, isBonusball);
        MatchStatus matchStatus2 = new MatchStatus(matchCount, isBonusball);
        MatchStatus matchStatus3 = new MatchStatus(matchCount, isBonusball);

        //Then
        assertThat(matchStatus).isEqualTo(matchStatus2).isEqualTo(matchStatus3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false",
            "5:false", "5:true", "6:false"}, delimiter = ':')
    public void equalsFalse(int matchCount, boolean isBonusball) {
        //Given
        MatchStatus matchStatus = new MatchStatus(matchCount, isBonusball);
        MatchStatus matchStatus2 = new MatchStatus(matchCount + 1, !isBonusball);
        MatchStatus matchStatus3 = new MatchStatus(matchCount + 2, isBonusball);

        //Then
        assertThat(matchStatus).isNotEqualTo(matchStatus2).isNotEqualTo(matchStatus3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false",
            "5:false", "5:true", "6:false"}, delimiter = ':')
    public void hashcodeTest(int matchCount, boolean isBonusball) {
        //Given
        Map<MatchStatus, Integer> map = new HashMap<>();

        //When
        map.put(new MatchStatus(matchCount, isBonusball), 0);
        map.put(new MatchStatus(matchCount, !isBonusball), 0);
        map.put(new MatchStatus(matchCount + 2, isBonusball),0);


        //Then
        assertThat(map).hasSize(3);
    }
}
