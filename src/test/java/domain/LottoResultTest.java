package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @ParameterizedTest
    @CsvSource({"6,1", "5,0", "2,0"})
    void win(int hitNumber, boolean matchBonus, int expect) {
        LottoResult lottoResult = LottoResult.of(Rank.FIRST);

        lottoResult.win(hitNumber, matchBonus);

        assertThat(lottoResult.getWinningCount()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"6,2000000000", "5,0", "2,0"})
    void calculateWinningMoney(int hitNumber, boolean matchBonus, int expect) {
        LottoResult lottoResult = LottoResult.of(Rank.FIRST);

        lottoResult.win(hitNumber, matchBonus);

        assertThat(lottoResult.calculateWinningMoney()).isEqualTo(expect);
    }
}
