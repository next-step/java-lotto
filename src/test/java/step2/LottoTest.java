package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domian.Calculator;
import step2.domian.Counter;
import step2.domian.Lotto;

import java.util.List;

public class LottoTest {

    @Test
    void 로또_지난주로또와_비교() {
        Lotto lastWinner = new Lotto(List.of(1, 2, 3, 4, 5));
        Lotto lotto1 = new Lotto(List.of(3, 4, 5, 6, 7));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 6, 7));

        Assertions.assertThat(Lotto.compareWithLastLotto(List.of(lotto1, lotto2), lastWinner).get(3)).isEqualTo(2);
    }


    @Test
    void count_로또_두개의_같은숫자_갯수() {
        Lotto lastWinner = new Lotto(List.of(1, 2, 3, 4, 5));
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7));


        Assertions.assertThat(Counter.countSameNumber(lotto, lastWinner)).isEqualTo(3);
    }

    @Test
    void calculate_수익률_로또만원사고_1000원당첨() {
        Assertions.assertThat(Calculator.calculatePercentage(10000, 1000)).isEqualTo(0.1f);
    }

    @Test
    void calculate_수익금_3개가_3개맞았을_때() {

        Assertions.assertThat(Calculator.calculateRevenue(List.of(0, 0, 0, 3, 0, 0, 0))).isEqualTo(15000);
    }
}
