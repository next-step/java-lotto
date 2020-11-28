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
        MatchStatus matchStatus = MatchStatus.of(matchCount, isBonusball);

        //Then
        assertThat(matchStatus).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false",
            "5:false", "5:true", "6:false"}, delimiter = ':')
    public void equalsTest(int matchCount, boolean isBonusball) {
        //Given
        MatchStatus matchStatus = MatchStatus.of(matchCount, isBonusball);
        MatchStatus matchStatus2 = MatchStatus.of(matchCount, isBonusball);
        MatchStatus matchStatus3 = MatchStatus.of(matchCount, isBonusball);

        //Then
        assertThat(matchStatus).isEqualTo(matchStatus2).isEqualTo(matchStatus3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false",
            "5:false", "5:true", "6:false"}, delimiter = ':')
    public void equalsFalse(int matchCount, boolean isBonusball) {
        //Given
        MatchStatus matchStatus = MatchStatus.of(matchCount, isBonusball);
        MatchStatus matchStatus2 = MatchStatus.of(matchCount + 1, !isBonusball);
        MatchStatus matchStatus3 = MatchStatus.of(matchCount + 2, isBonusball);

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
        map.put(MatchStatus.of(matchCount, isBonusball), 0);
        map.put(MatchStatus.of(matchCount, isBonusball), 0);
        map.put(MatchStatus.of(matchCount + 2, isBonusball),0);


        //Then
        assertThat(map).hasSize(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:true", "4:true", "5:false", "5:true", "6:false"}, delimiter = ':')
    public void changeBonusballStatus(int matchCount, boolean isBonusball){
        //Given
        MatchStatus matchStatus = MatchStatus.of(matchCount, isBonusball);

        //When
        PrizeInformation prizeInformation = PrizeInformation.findByPrizePrice(matchStatus);

        //Then
        assertThat(prizeInformation.getMatchStatus()).isEqualTo(matchStatus);
    }
}
