package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/rank.csv", delimiter = ':')
    public void valueOf(String countOfMatchInput, String matchBonusInput, String expectedInput) {
        final LottoRank expected = LottoRank.valueOf(expectedInput);

        final int countOfMatch = Integer.parseInt(countOfMatchInput);
        final boolean matchBonus = Boolean.parseBoolean(matchBonusInput);
        final LottoRank result = LottoRank.valueOf(countOfMatch, matchBonus);

        System.out.println(result);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:2000000000", "SECOND:30000000", "THIRD:1500000", "FOURTH:50000", "FIFTH:5000", "MISS:0"}, delimiter = ':')
    public void winningPrize(String lottoRankInput, String expectedInput) {
        final int expected = Integer.parseInt(expectedInput);

        final LottoRank lottoRank = LottoRank.valueOf(lottoRankInput);
        final int result = lottoRank.winningPrize();

        assertThat(result).isEqualTo(expected);
    }
}
