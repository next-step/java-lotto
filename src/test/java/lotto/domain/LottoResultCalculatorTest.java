package lotto.domain;

import lotto.domain.strategy.FiveAndBonusMatchStrategy;
import lotto.domain.strategy.ThreeMatchStrategy;
import lotto.domain.strategy.WinningStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultCalculatorTest {

    @Test
    @DisplayName("3개의 맞춘 결과를 계산한다.")
    void testCalculateResultsUsingThreeMatchStrategy() {
        // given
        ThreeMatchStrategy threeMatchStrategy = new ThreeMatchStrategy();
        List<WinningStrategy> strategies = Arrays.asList(threeMatchStrategy);
        LottoResultCalculator calculator = new LottoResultCalculator(strategies);

        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 10, 11, 12"), // 3 matches
                new Lotto("4, 5, 6, 10, 11, 12"), // no match
                new Lotto("1, 2, 3, 4, 5, 6")));    // 3 matches
        Lotto winningNumbers = new Lotto("1, 2, 3, 7, 8, 9");

        // when
        Map<String, Integer> results = calculator.calculateResults(lottos, winningNumbers, null);

        // then
        assertThat(results.getOrDefault("threeMatch", 0)).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void testCalculateProfitUsingThreeMatchStrategy() {
        // given
        ThreeMatchStrategy threeMatchStrategy = new ThreeMatchStrategy();
        List<WinningStrategy> strategies = Arrays.asList(threeMatchStrategy);
        LottoResultCalculator calculator = new LottoResultCalculator(strategies);

        Map<String, Integer> results = new HashMap<>();
        results.put("threeMatch", 2);

        // when
        double profit = calculator.calculateProfit(results, 10); // 10 tickets

        // then
        double expectedProfitRate = 1.0;
        assertThat(profit).isEqualTo(expectedProfitRate);
    }

    @Test
    @DisplayName("로또 번호 5개와 보너스 번호를 맞추는 경우 테스트")
    void fiveAndBonusMatchTest() {
        // given
        WinningStrategy threeMatchStrategy = new FiveAndBonusMatchStrategy();
        List<WinningStrategy> strategies = List.of(threeMatchStrategy);
        LottoResultCalculator calculator = new LottoResultCalculator(strategies);

        Lottos lottos = new Lottos(List.of(
                new Lotto("1, 2, 3, 4, 5, 6")
        ));
        Lotto winningNumbers = new Lotto("1, 2, 3, 4, 5, 9");
        LottoNumber bonusNumber = new LottoNumber(6);

        // when
        Map<String, Integer> results = calculator.calculateResults(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(results.getOrDefault("fiveMatchWithBonus", 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호 5개와 보너스 번호를 맞추지 못하는 경우 테스트")
    void fiveMatchAndNotBonusTest() {
        // given
        WinningStrategy threeMatchStrategy = new FiveAndBonusMatchStrategy();
        List<WinningStrategy> strategies = List.of(threeMatchStrategy);
        LottoResultCalculator calculator = new LottoResultCalculator(strategies);

        Lottos lottos = new Lottos(List.of(
                new Lotto("1, 2, 3, 4, 5, 6")
        ));
        Lotto winningNumbers = new Lotto("1, 2, 3, 4, 5, 9");
        LottoNumber bonusNumber = new LottoNumber(10);

        // when
        Map<String, Integer> results = calculator.calculateResults(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(results.getOrDefault("fiveMatchWithBonus", 0)).isZero();
    }
}

