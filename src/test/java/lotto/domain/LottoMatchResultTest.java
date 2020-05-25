package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchResultTest {

    private LottoMatchResult lottoMatchResult;

    @BeforeEach
    void setUp() {
        LottoGame lottoGame = new LottoGame();
        List<String> manual = Arrays.asList(
                "1, 2, 3, 13, 14, 15",
                "1, 2, 3, 4, 14, 15",
                "1, 2, 3, 4, 5, 15",
                "1, 2, 3, 4, 5, 7",
                "1, 2, 3, 4, 5, 6"
        );
        lottoGame.createManualLottoNumbers(manual);

        LottoNumbers winLottoNumbers = LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6));
        this.lottoMatchResult = lottoGame.calculateMatchCount(winLottoNumbers, 7);
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
                Arguments.of(LottoMatch.FIVE_BONUS),
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
    @MethodSource("generateMatchCountForLottoMatch")
    void canGetMatchCount(LottoMatch lottoMatch, int result) {
        assertThat(this.lottoMatchResult.getMatchCount(lottoMatch)).isEqualTo(result);
    }

    static Stream<Arguments> generateMatchCountForLottoMatch() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE, 1),
                Arguments.of(LottoMatch.FOUR, 1),
                Arguments.of(LottoMatch.FIVE, 1),
                Arguments.of(LottoMatch.FIVE_BONUS, 1),
                Arguments.of(LottoMatch.SIX, 1)
        );
    }

    @DisplayName("당첨금을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateWinAmountForLottoMatch")
    void canCalculateWinAmount(LottoMatch lottoMatch, long result) {
        assertThat(this.lottoMatchResult.calculateWinAmount(lottoMatch)).isEqualTo(result);
    }

    static Stream<Arguments> generateWinAmountForLottoMatch() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE, 5_000),
                Arguments.of(LottoMatch.FOUR, 50_000),
                Arguments.of(LottoMatch.FIVE, 1_500_000),
                Arguments.of(LottoMatch.FIVE_BONUS, 30_000_000),
                Arguments.of(LottoMatch.SIX, 2_000_000_000)
        );
    }

    @DisplayName("총 수익률을 계산할 수 있다.")
    @Test
    void canCalculateProfitRate() {
        assertThat(this.lottoMatchResult.calculateProfitRate(5)).isEqualTo(406_311_000);
    }
}
