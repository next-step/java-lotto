package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/rank.csv", delimiter = ':')
    public void valueOf(String countOfMatchInput, String matchBonusInput, String expectedInput) {
        final Rank expected = Rank.valueOf(expectedInput);

        final int countOfMatch = Integer.parseInt(countOfMatchInput);
        final boolean matchBonus = Boolean.parseBoolean(matchBonusInput);
        final Rank result = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(result).isEqualTo(expected);
    }
}
