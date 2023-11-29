package step2.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @DisplayName("맞춘 숫자에 맞는 등수가 정해진다.")
    @CsvSource(value = {"0,MISS", "3,FOURTH", "4,THIRD", "5,SECOND", "6,FIRST"}, delimiter = ',')
    void winningNumber_rank(int correctNumber, String rank) {
        Assertions.assertThat(Rank.valueOf(correctNumber).name()).isEqualTo(rank);
    }

    @ParameterizedTest
    @DisplayName("맞춘 숫자에 맞는 상금이 정해진다.")
    @CsvSource(value = {"0,0", "3,5000", "4,50000", "5,1500000", "6,2000000000"}, delimiter = ',')
    void winningNumber_winningMoney(int correctNumber, int winningMoney) {
        Assertions.assertThat(Rank.valueOf(correctNumber).getWinningMoney()).isEqualTo(new Money(winningMoney));
    }

}