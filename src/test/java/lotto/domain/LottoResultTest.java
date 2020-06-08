package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {
    private List<Lotto> lottos;

    @BeforeEach
    void setup() {
        lottos = new ArrayList<>();
        int[] intNumbers = {1, 10, 30, 33, 40, 45};
        List<Integer> numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());
        lottos.add(new Lotto(numbers));

        intNumbers = new int[]{1, 12, 20, 22, 40, 45};
        numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());
        lottos.add(new Lotto(numbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"45,1", "20,0"})
    @DisplayName("맞춘 번호 개수별 합계 확인")
    void matchResult(int bonusBall, int expected) {
        String[] winningNumbers = {"1", "10", "30", "33", "40", "41"};
        WinningNumber winningNumber = new WinningNumber(winningNumbers, new LottoNumber(bonusBall));

        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.matchResult(lottos, winningNumber);

        assertAll(
                () -> assertThat(result.get(Rank.FIFTH)).isEqualTo(0),
                () -> assertThat(result.get(Rank.FOURTH)).isEqualTo(0),
                () -> assertThat(result.get(Rank.SECOND)).isEqualTo(expected)
        );
    }
}
