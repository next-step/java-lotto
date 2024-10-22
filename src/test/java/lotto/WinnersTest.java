package lotto;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnersTest {

    @Test
    @DisplayName("지난 주 당첨 번호를 입력 받는다.")
    void testWinners() {
        Winners winners = new Winners("14, 16, 21, 25, 38, 40");
        assertThat(winners.toString()).isEqualTo("[14, 16, 21, 25, 38, 40]");
    }

    @Test
    @DisplayName("당첨 번호도 로또 번호와 동일한 제약 설정")
    void testWinnersConstraint() {
        assertThatThrownBy(() -> {
            new Winners("100");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Winners("0, 16, 21, 25, 38, 40");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Winners("46, 16, 21, 25, 38, 40");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 통계를 계산한다.")
    void testPrintWinners() {
        List<Lotto> lottos = List.of(new Lotto(1L), new Lotto(2L));
        Orders orders = new Orders(lottos);

        Winners winners = new Winners("14, 16, 21, 25, 38, 40");
        Statistics statistics = winners.match(orders);

        assertThat(statistics.get(3)).isEqualTo(0);
        assertThat(statistics.get(4)).isEqualTo(0);
        assertThat(statistics.get(5)).isEqualTo(1);
        assertThat(statistics.get(6)).isEqualTo(0);
    }
}
