package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LottoRankTest {

    @ParameterizedTest
    @EnumSource(LottoRank.class)
    void 맞춘갯수를_당첨등수로_변환(LottoRank lottoRank) {
        Assertions.assertThat(LottoRank.findRank(lottoRank.getCorrectNum())).isEqualTo(lottoRank);
    }

}