package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @ParameterizedTest
    @CsvSource({"6,false,1", "5,true,2", "5,false,3", "4,false,4", "3,false,5", "2,false,0",
        "3,true,5", "4,true,4"})
    void valueOf(String hitCountInput, String isMatchedBonusInput, String prizeInput) {
        //given
        int hitCount = Integer.valueOf(hitCountInput);
        boolean isMatchedBonus = Boolean.valueOf(isMatchedBonusInput);

        //when&then
        assertThat(Prize.valueOf(hitCount, isMatchedBonus).getGrade())
            .isEqualTo(Integer.valueOf(prizeInput));
    }

    @Test
    void winningValues() {
        //when
        Prize[] prizes = Prize.winningValues();

        //then
        assertThat(prizes.length).isEqualTo(Prize.values().length - 1);
    }
}