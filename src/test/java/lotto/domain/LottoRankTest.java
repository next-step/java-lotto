package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("matchCount에 따른 LottoRank 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            " 0 | false | NONE ",
            " 0 |  true | NONE ",
            " 1 | false | NONE ",
            " 1 |  true | NONE ",
            " 2 | false | NONE ",
            " 2 |  true | NONE ",
            " 3 | false | FIFTH ",
            " 3 |  true | FIFTH ",
            " 4 | false | FOURTH ",
            " 4 |  true | FOURTH ",
            " 5 | false | THIRD ",
            " 5 |  true | SECOND ",
            " 6 | false | FIRST ",
            " 6 |  true | FIRST ",
    }, delimiter = '|')
    void of(int matchCount, boolean matchBonus, LottoRank exptectedLottoRank) {
        LottoRank lottoRank = LottoRank.of(matchCount, matchBonus);
        assertThat(lottoRank).isEqualTo(exptectedLottoRank);
    }
}
