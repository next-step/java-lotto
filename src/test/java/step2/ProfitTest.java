package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    @Test
    @DisplayName("총 수익률 합 테스트 - 4등 2개, 5등 1개 - 총 10만 5천원")
    void profit_test_sum() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers2 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers3 = new InputNumber("1,2,3,43,44,45");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers),bonusBall);
        LottoNumberGenerator generator = () ->
                Arrays.asList(new Lotto(purchasedNumbers1),
                        new Lotto(purchasedNumbers2), new Lotto(purchasedNumbers3));

        Lottos lottos = Lottos.of(generator);
        Rank rank = lottos.makeStatistic(winningLotto);

        double sum = rank.getRank().keySet().stream().
                mapToDouble(lottoPrize -> lottoPrize.prize() * rank.size(lottoPrize)).sum();

        assertThat(sum).isEqualTo(105000);
    }

    @Test
    @DisplayName("총 수익률 합 테스트(2등 추가) -2등 1개, 3등 1개, 4등 2개, 5등 1개 - 총 1160만 5천원")
    void profit_test_second_sum() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,4,5,7");
        InputNumber purchasedNumbers2 = new InputNumber("1,2,3,4,5,45");
        InputNumber purchasedNumbers3 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers4 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers5 = new InputNumber("1,2,3,43,44,45");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers),bonusBall);
        LottoNumberGenerator generator = () ->
                Arrays.asList(new Lotto(purchasedNumbers1),
                        new Lotto(purchasedNumbers2), new Lotto(purchasedNumbers3)
                    ,new Lotto(purchasedNumbers4),new Lotto(purchasedNumbers5));

        Lottos lottos = Lottos.of(generator);
        Rank rank = lottos.makeStatistic(winningLotto);

        double sum = rank.getRank().keySet().stream().
                mapToDouble(lottoPrize -> lottoPrize.prize() * rank.size(lottoPrize)).sum();

        assertThat(sum).isEqualTo(11605000);
    }

    @Test
    @DisplayName("수익률 구현 테스트 - 4등 2개, 5등 1개 - 총 구입금액 3천원")
    void profit_test() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers2 = new InputNumber("1,2,3,4,44,45");
        InputNumber purchasedNumbers3 = new InputNumber("1,2,3,43,44,45");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers),bonusBall);
        LottoNumberGenerator generator = () ->
                Arrays.asList(new Lotto(purchasedNumbers1),
                        new Lotto(purchasedNumbers2), new Lotto(purchasedNumbers3));
        Lottos lottos = Lottos.of(generator);

        Rank rank = lottos.makeStatistic(winningLotto);
        Money money= new Money(3000);

        double sum = rank.getRank().keySet().stream().
                mapToDouble(lottoPrize -> lottoPrize.prize() * rank.size(lottoPrize)).sum();
        double profit = sum/ money.getMoney();
        assertThat(profit).isEqualTo(35.0);
    }

    @Test
    @DisplayName("수익률 구현 테스트(2등테스트) - 2등 1개, 5등 1개 - 총 구입금액 2천원")
    void profit_second_test(){
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,4,5,7");
        InputNumber purchasedNumbers2 = new InputNumber("1,2,3,43,44,45");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers),bonusBall);
        LottoNumberGenerator generator = () ->
                Arrays.asList(new Lotto(purchasedNumbers1), new Lotto(purchasedNumbers2));

        Lottos lottos = Lottos.of(generator);
        Rank rank = lottos.makeStatistic(winningLotto);

        double sum = rank.getRank().keySet().stream().
                mapToDouble(lottoPrize -> lottoPrize.prize() * rank.size(lottoPrize)).sum();
        Money money= new Money(2000);
        double profit = sum/ money.getMoney();
        assertThat(profit).isEqualTo(5002.5);
    }
}
