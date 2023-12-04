package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    @DisplayName("로또가 일치한 숫자에 해당 하는 상금을 얻는다.")
    void correctNumbers_giveWinningMoney(int matchedNumber, int winningMoney) {
        Assertions.assertThat(Prize.valueOf(matchedNumber).getWinningMoney())
                .isEqualTo(new Money(winningMoney));
    }


    @ParameterizedTest
    @DisplayName("로또가 일치하는 수에 맞는 로또 등수가 정해진다.")
    @CsvSource(value = {"0,MISS", "3,FOURTH", "4,THIRD", "5,SECOND", "6,FIRST"}, delimiter = ',')
    void winningNumber_rank(int correctNumber, String rank) {
        Assertions.assertThat(Prize.valueOf(correctNumber).name()).isEqualTo(rank);
    }

    @ParameterizedTest
    @DisplayName("로또가 일치한 숫자에 맞는 상금이 정해진다.")
    @CsvSource(value = {"0,0", "3,5000", "4,50000", "5,1500000", "6,2000000000"}, delimiter = ',')
    void winningNumber_winningMoney(int correctNumber, int winningMoney) {
        Assertions.assertThat(Prize.valueOf(correctNumber).getWinningMoney()).isEqualTo(new Money(winningMoney));
    }

    @ParameterizedTest
    @DisplayName("로또가 일치한 수에 맞는 등수에 맞게 상금이 정해진다.")
    @CsvSource(value = {"MISS,0", "FOURTH,5000", "THIRD,50000", "SECOND,1500000", "FIRST,2000000000"}, delimiter = ',')
    void winningRank_winningMoney(String rank, int winningMoney) {
        Assertions.assertThat(Prize.valueOf(rank).getWinningMoney()).isEqualTo(new Money(winningMoney));
    }
}