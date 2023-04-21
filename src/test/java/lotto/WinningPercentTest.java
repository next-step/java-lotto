package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import lotto.WinningNumbers.Rank;
import org.junit.jupiter.api.Test;

public class WinningPercentTest {

    @Test
    void 수익률리턴() {
        assertThat(new WinningPercent(1.0d).value()).isEqualTo(1.0d);
    }

    @Test
    void 수익률계산() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class){{
            put(Rank.FIRST_GRADE, 1);
            put(Rank.SECOND_GRADE, 1);
            put(Rank.THIRD_GRADE, 1);
            put(Rank.FOURTH_GRADE, 1);
        }};
        int amount = 5000;
        double winningPercent = 0.0d;
        for (Rank rank : result.keySet()) {
            winningPercent += (rank.amount() * result.get(rank));
        }
        winningPercent /= amount;

        assertThat(WinningPercent.winningPercent(result, amount)).isEqualTo(new WinningPercent(winningPercent));
    }

    @Test
    void 수익률생성() {
        assertThat(new WinningPercent(1.0d)).isEqualTo(new WinningPercent(1.0d));
    }

}
