package lotto;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {


    @Test
    void calculateWinningResult_테스트() {
        // Given
        WinningResult winningResult = new WinningResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        winningResult.calculateWinningResult(lottos, new Lotto(winningNumbers));
        EnumMap<WinningPrice, Integer> result = winningResult.getWinningResult();

        // Then
        assertThat(1).isEqualTo(result.get(WinningPrice.FIRST));
        assertThat(1).isEqualTo(result.get(WinningPrice.SECOND));
        assertThat(1).isEqualTo(result.get(WinningPrice.THIRD));
    }

    @Test
    void calculateRateOfReturn_테스트() {
        // Given
        WinningResult winningResult = new WinningResult();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        winningResult.calculateWinningResult(lottos, new Lotto(winningNumbers));
        int amount = 3000;

        // When
        Double rateOfReturn = winningResult.calculateRateOfReturn(amount);

        // Then
        assertThat(rateOfReturn).isEqualTo(0.05);
    }
}
