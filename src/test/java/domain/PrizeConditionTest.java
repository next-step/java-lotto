package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeConditionTest {

    @DisplayName("Test of getting prize condition with matching number count and bonus number")
    @ParameterizedTest
    @CsvSource(value = {
            "3:false:FIFTH",
            "3:true:FIFTH",
            "4:false:FOURTH",
            "4:true:FOURTH",
            "5:false:THIRD",
            "5:true:SECOND",
            "6:false:FIRST",
    }, delimiter = ':')
    void testPrizeCondition(int matchingNumberCount, boolean bonusIncluded, String nameOfPrize) {
        Optional<PrizeCondition> prizeCondition = PrizeCondition.of(matchingNumberCount, bonusIncluded);
        prizeCondition.ifPresent(condition -> assertThat(condition).isEqualTo(PrizeCondition.valueOf(nameOfPrize)));
    }

    @DisplayName("Test of losing condition")
    @ParameterizedTest
    @CsvSource(value = {
            "0:false",
            "0:true",
            "1:false",
            "1:true",
            "2:false",
            "2:true"
    }, delimiter = ':')
    void testLosingNumber(int matchingNumberCount, boolean bonusIncluded) {
        Optional<PrizeCondition> prizeCondition = PrizeCondition.of(matchingNumberCount, bonusIncluded);
        assertThat(prizeCondition.isPresent()).isFalse();
    }
}
