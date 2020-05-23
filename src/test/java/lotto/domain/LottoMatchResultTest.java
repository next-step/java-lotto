package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchResultTest {

    private LottoMatchResult lottoMatchResult;

    @BeforeEach
    void setUp() {
        LottoGame lottoGame = new LottoGame(14000);
        lottoGame.createLottoNumbers();

        LottoNumbers winLottoNumbers = LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6));
        this.lottoMatchResult = lottoGame.calculateMatchCount(winLottoNumbers);
    }

    @DisplayName("당첨 개수를 1씩 증가할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateLottoMatch")
    void canIncreaseMatchCount(LottoMatch lottoMatch) {
        int matchCount = this.lottoMatchResult.getMatchCount(lottoMatch);
        this.lottoMatchResult.increaseMatchCount(lottoMatch);

        int increasedMatchCount = this.lottoMatchResult.getMatchCount(lottoMatch);
        assertThat(matchCount + 1).isEqualTo(increasedMatchCount);
    }

    static Stream<Arguments> generateLottoMatch() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE),
                Arguments.of(LottoMatch.FOUR),
                Arguments.of(LottoMatch.FIVE),
                Arguments.of(LottoMatch.SIX)
        );
    }

    @DisplayName("수익률에 대한 결과를 얻을 수 있다.")
    @ParameterizedTest
    @CsvSource(value = { "0.5,손해", "1.0,이익", "1.5,이익" })
    void canGetProfitOrLoss(double rate, String result) {
        assertThat(this.lottoMatchResult.getProfitOrLoss(rate)).isEqualTo(result);
    }

    @DisplayName("당첨 개수를 0 이상 값을 얻을 수 있다.")
    @ParameterizedTest
    @MethodSource("generateLottoMatch")
    void canGetMatchCount(LottoMatch lottoMatch) {
        assertThat(this.lottoMatchResult.getMatchCount(lottoMatch)).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("당첨금을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateLottoMatch")
    void canCalculateWinAmount(LottoMatch lottoMatch) {
        assertThat(this.lottoMatchResult.calculateWinAmount(lottoMatch)).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("총 수익률을 계산할 수 있다.")
    @Test
    void canCalculateProfitRate() {
        assertThat(this.lottoMatchResult.calculateProfitRate(14)).isGreaterThanOrEqualTo(0);
    }
}
