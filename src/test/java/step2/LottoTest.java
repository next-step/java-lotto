package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    void COUNT_같은_숫자_갯수() {
        List<Integer> lastNumber = List.of(1,2,3,4,5);
        List<Integer> lottoNumber = List.of(3,4,5,6,7);
        Assertions.assertThat(Calculator.countSameNumber(lastNumber,lottoNumber)).isEqualTo(3);
    }
    @Test
    void calculate_수익률_로또만원사고_1000원당첨() {
        Assertions.assertThat(Calculator.calculatePercentage(10000,1000)).isEqualTo(0.1f);
    }

    @Test
    void calculate_수익금_3개가_3개맞았을_때() {
        Assertions.assertThat(Calculator.calculateRevenue(List.of(3,3,3))).isEqualTo(15000);
    }
}
