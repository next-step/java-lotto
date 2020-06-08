package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    private List<LottoPrize> lottoPrizeList;

    @BeforeEach
    void setup() {
        List<Lotto> lottos = new ArrayList<>();
        int[] intNumbers = {1, 10, 30, 33, 40, 45};
        List<Integer> numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());
        lottos.add(new Lotto(numbers));

        intNumbers = new int[]{1, 12, 20, 22, 40, 45};
        numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());
        lottos.add(new Lotto(numbers));

        int[] intWinningNumbers = {1, 12, 30, 33, 35, 41};
        List<Integer> winningNumbers = Arrays.stream(intWinningNumbers).boxed().collect(Collectors.toList());

        LottoMatcher lottoMatcher = new LottoMatcher(lottos, winningNumbers);
        lottoPrizeList = lottoMatcher.getLottoPrizeList();
    }

    @Test
    @DisplayName("맞춘 번호 개수별 합계 확인")
    void matchResult() {
        LottoResult lottoResult = new LottoResult(lottoPrizeList);
        Map<Integer, Integer> resultMap = lottoResult.matchResult();

        assertAll(
                () -> assertThat(resultMap.get(3)).isEqualTo(1),
                () -> assertThat(resultMap.get(4)).isNull(),
                () -> assertThat(resultMap.get(5)).isNull()
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"2000,250"})
    @DisplayName("수익률")
    void statistics(int money, int expected) {
        LottoResult lottoResult = new LottoResult(lottoPrizeList);

        int result = (int) (lottoResult.statistics(money) * 100);
        assertThat(result).isEqualTo(expected);
    }
}
