package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @ParameterizedTest
    @CsvSource(
            value = {"6:true:FIRST", "6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "2:true:NONE", "2:false:NONE"},
            delimiter = ':'
    )
    void 당첨_등수_구하기(int equalNumberCount, boolean hasBonusNumber, LottoRank expectedRank) {
        // when
        LottoRank lottoRank = LottoRank.of(equalNumberCount, hasBonusNumber);

        // then
        Assertions.assertThat(lottoRank).isEqualTo(expectedRank);
    }
}
