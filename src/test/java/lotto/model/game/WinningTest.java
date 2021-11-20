package lotto.model.game;

import lotto.model.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @ParameterizedTest
    @CsvSource(value = {"4,0","3,1","1,1"})
    @DisplayName("당첨되는 항목 개수 플러스 되는 것 테스트")
    void winningPlusTest(int match, int result){
        Winning.win(match);
        String print =  "3개 일치 (5000 원)- " + result + "개";
        assertThat(Winning.THREE_MATCH.print()).isEqualTo(print);
    }

    @ParameterizedTest
    @CsvSource(value = { "3,5", "1,5", "4,55"})
    @DisplayName("수익률 계산 테스트")
    void getProfitTest(int match, double expected) {
        Winning.win(match);
        assertThat(Winning.getProfit(1000)).isEqualTo(expected);
    }
}