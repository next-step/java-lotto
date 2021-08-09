package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AwardTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST:6:2000000000", "SECOND:5:1500000", "THIRD:4:50000","FOURTH:3:5000"}
    ,delimiter = ':')
    @DisplayName("각 Award와 매칭되는 숫자의 갯수와 금액을 확인한다.")
    void awardMatchAndAmount(String type, int matchNumbers, int amount){
        Award award = Award.valueOf(type);
        assertEquals(award.getMatchNumbers(), matchNumbers);
        assertEquals(award.getAmount(), amount);
    }
}