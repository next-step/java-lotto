package lotto.model;

import lotto.model.enums.MatchingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingStrategyTest {

    @Test
    @DisplayName("2등 당첨자 보너스 당첨일 경우 추출 테스트")
    void when_win_bonus_number(){
        assertThat(MatchingStrategy.find(5, true)).isEqualTo(MatchingStrategy.FIVE_WITH_BONUS);
    }

    @Test
    @DisplayName("2등 당첨자 보너스 당첨 안했을 경우 추출 테스트")
    void when_no_win_bonus_number(){
        assertThat(MatchingStrategy.find(5, false)).isEqualTo(MatchingStrategy.FIVE);
    }

    @DisplayName("당첨자 추출 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:THREE","4:FOUR","5:FIVE","6:SIX"}, delimiter = ':')
    void check_get_winner(int element,String matchingStrategy ){
        assertThat(MatchingStrategy.find(element, false)).isEqualTo(MatchingStrategy.valueOf(matchingStrategy));
    }
}
