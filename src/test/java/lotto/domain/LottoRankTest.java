package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST:false", "SECOND:false", "BONUS:true"}, delimiter = ':')
    void 맞춘갯수를_당첨등수로_변환(LottoRank lottoRank, boolean matchBonus) {
        Assertions.assertThat(LottoRank.findRank(lottoRank.getCorrectNum(), matchBonus)).isEqualTo(lottoRank);
    }

}