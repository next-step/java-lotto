package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AwardTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST:6:false:2000000000", "SECOND:5:true:30000000", "THIRD:5:false:1500000", "FOURTH:4:false:50000", "FIFTH:3:false:5000"}
            , delimiter = ':')
    @DisplayName("각 Award와 매칭되는 숫자의 갯수와 금액을 확인한다.")
    void awardMatchAndAmount(String type, int matchNumbers, boolean bonus, int amount) {
        Award award = Award.valueOf(type);
        assertEquals(award.getMatchNumbers(), matchNumbers);
        if(matchNumbers == 5){
            assertEquals(award.isBonus(), bonus);
        }
        assertEquals(award.getAmount(), amount);
    }
}