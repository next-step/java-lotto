package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private List<LottoNumber> lottoNumbers;
    private List<Integer> winningNumbers;

    @BeforeEach
    void setup() {
        lottoNumbers = new ArrayList<>();
        int[] intNumbers = {1, 10, 30, 33, 40, 45};
        List<Integer> numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());
        lottoNumbers.add(new LottoNumber(numbers));

        intNumbers = new int[]{1, 12, 20, 22, 40, 45};
        numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());
        lottoNumbers.add(new LottoNumber(numbers));

        int[] intWinningNumbers = {1, 12, 30, 33, 35, 41};
        winningNumbers = Arrays.stream(intWinningNumbers).boxed().collect(Collectors.toList());
    }

    @Test
    void matchList() {
        LottoResult lottoResult = new LottoResult(lottoNumbers, winningNumbers);
        lottoResult.matchList();

        Map<String, Integer> resultMap = lottoResult.getResultMap();
        assertThat(resultMap.get("2")).isEqualTo(1);
        assertThat(resultMap.get("3")).isEqualTo(1);
        assertThat(resultMap.get("4")).isEqualTo(null);
    }

    @Test
    @DisplayName("수익률")
    void statistics() {
        LottoResult lottoResult = new LottoResult(lottoNumbers, winningNumbers);
        lottoResult.matchList();

        int result = (int) (lottoResult.statistics(2000) * 100);
        assertThat(result).isEqualTo(250);
    }
}
