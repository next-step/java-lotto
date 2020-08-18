package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @ParameterizedTest
    @CsvSource({"6,true,1,0,0,0,0", "5,true,0,1,0,0,0", "5,false,0,0,1,0,0",
            "4,false,0,0,0,1,0", "3,false,0,0,0,0,1", "2,false,0,0,0,0,0"})
    void win(int hitNumber, boolean matchBonus, int first, int second, int third, int fourth, int fifth) {
        LottoResults results = LottoResults.of();

        results.win(hitNumber, matchBonus);

        assertThat(results.getLottoResults()).extracting(LottoResult::getWinningCount)
                .containsExactly(first, second, third, fourth, fifth);
    }
}
