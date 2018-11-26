package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 총수입계산() {
        Map<LottoType, Integer> winnings = new HashMap<>();
        winnings.put(LottoType.THREE, 3);
        winnings.put(LottoType.FOUR, 2);
        LottoResult lottoResult = new LottoResult(winnings);

        double result = lottoResult.computeEarning();

        assertThat(result).isEqualTo(115000.0);
    }
}