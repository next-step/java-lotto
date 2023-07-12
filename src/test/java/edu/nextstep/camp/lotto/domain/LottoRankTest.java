package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = { "6:FIRST", "5:SECOND", "4:THIRD", "2:NONE"})
    void 로또_랭크_매치_갯수로_객체_생성(int matchCount, String expected){
        LottoRank lottoRank = LottoRank.withMatchNumberCount(matchCount);

        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(expected));
    }
}
