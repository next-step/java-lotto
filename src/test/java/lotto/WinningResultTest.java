package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {


    @Test
    void calculateWinningResult_테스트() {
        // Given
        WinningResult winningResult = new WinningResult();
        Map<Integer, List<Integer>> lottoNumbers = new HashMap<>();
        lottoNumbers.put(1, Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.put(2, Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoNumbers.put(3, Arrays.asList(1, 2, 3, 4, 8, 9));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        winningResult.calculateWinningResult(lottoNumbers, winningNumbers);
        Map<Integer, Integer> result = winningResult.getWinningResult();

        // Then
        assertThat(1).isEqualTo(result.get(6));
        assertThat(1).isEqualTo(result.get(5));
        assertThat(1).isEqualTo(result.get(4));
    }

    @Test
    void calculateRateOfReturn_테스트() {
        // Given
        WinningResult winningResult = new WinningResult();
        Map<Integer, List<Integer>> lottoNumbers = new HashMap<>();
        lottoNumbers.put(1, Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.put(2, Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoNumbers.put(3, Arrays.asList(1, 2, 3, 4, 8, 9));
        List<Integer> winningNumbers = Arrays.asList(1,2,3,10,11,12);
        winningResult.calculateWinningResult(lottoNumbers, winningNumbers);
        int amount = 3000;

        // When
        Double rateOfReturn = winningResult.calculateRateOfReturn(amount);

        // Then
        assertThat(rateOfReturn).isEqualTo(0.05);
    }
}
