package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("matchCount에 따른 LottoRank 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            " 0 | NONE ",
            " 1 | NONE ",
            " 2 | NONE ",
            " 3 | FOURTH ",
            " 4 | THIRD ",
            " 5 | SECOND ",
            " 6 | FIRST ",
    }, delimiter = '|')
    void of(int matchCount, LottoRank exptectedLottoRank) {
        LottoRank lottoRank = LottoRank.of(matchCount);
        assertThat(lottoRank).isEqualTo(exptectedLottoRank);
    }
}
