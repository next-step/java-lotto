package lotto;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @DisplayName("로또 구매 금액과 결제 된 로또 수량이 알맞는지")
    @ParameterizedTest
    @CsvSource({
        "14000, 14",
        "5500, 5",
        "300, 0",
    })
    void matchPriceAndPayment(int input, int output) {
        Buyer number = new Buyer();

        assertThat(number.matchPriceAndPayment(input)).isEqualTo(output);
    }

    @DisplayName("실제 로또 당첨 번호와 일치하는 번호를 넣었을 때 일치하는지")
    @Test
    void winningNumberEqual() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> input = List.of(1,2,3,4,5,6);
        assertThat(lotto.getLotto()).isEqualTo(input);
    }

    @DisplayName("실제 로또 보너스 번호와 일치하는 번호를 넣었을 떄 일치하는지")
    @Test
    void bonusEqual() {
        Lotto lotto = new Lotto(3);
        Integer input = 3;
        assertThat(lotto.getBonusNumber()).isEqualTo(input);
    }

    @DisplayName("당첨 번호 맞는 갯수에 따라 당첨 통계를 잘 내는지")
    @Test
    void winningStatisticalCheck() {
        Lotto lotto = new Lotto(List.of(1,3,5,7,9,13));
        List<Integer> input = List.of(1,2,3,4,5,6);
        Integer result = 3;
        assertThat(lotto.countMatches(input)).isEqualTo(result);
    }

//    @DisplayName("실제 로또 당첨 번호와 일치하는 번호를 넣었을 때 일치하는지")
//    @Test
//    void winningNumberEqual() {
//        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
//        List<Integer> input = List.of(1,2,3,4,5,6);
//        assertThat(lotto.getLotto()).isEqualTo(input);
//    }
//
//    @DisplayName("실제 로또 보너스 번호와 일치하는 번호를 넣었을 떄 일치하는지")
//    @Test
//    void bonusEqual() {
//        Lotto lotto = new Lotto(3);
//        Integer input = 3;
//        assertThat(lotto.getBonusNumber()).isEqualTo(input);
//    }
//
//    @DisplayName("당첨 번호 맞는 갯수에 따라 당첨 통계를 잘 내는지")
//    @Test
//    void winningStatisticalCheck() {
//        Lotto lotto = new Lotto(List.of(1,3,5,7,9,13));
//        List<Integer> input = List.of(1,2,3,4,5,6);
//        Integer result = 3;
//        assertThat(lotto.countMatches(input)).isEqualTo(result);
//    }

    @DisplayName("당첨 통계에 따라 수익률을 잘 계산하는지")
    @Test
    void winningRevenueCheck() {
        MatchResult result = new MatchResult(5, List.of(2, 0, 0, 0, 0));
        assertThat(result.CalculateWinningRevenue()).isEqualTo(2.0);
    }
}
