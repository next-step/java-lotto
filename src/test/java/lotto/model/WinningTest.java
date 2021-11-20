package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @ParameterizedTest
    @CsvSource(value = {"4,0","3,1","1,1"})
    void winningPlusTest(int match, int result){
        Winning.win(match);
        String print =  "3개 일치 (5000 원)- " + result + "개";
        assertThat(Winning.THREE_MATCH.print()).isEqualTo(print);
    }

    @ParameterizedTest
    @CsvSource(value = { "3,5", "1,5", "4,55"})
    void getProfitTest(int match, double expected) {
        Winning.win(match);
        assertThat(Winning.getProfit(1000)).isEqualTo(expected);
    }
}