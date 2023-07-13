package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:true:FOURTH", "3:true:FIFTH", "2:true:NONE"})
    void 로또_랭크_매치_갯수로_2등포함_객체_생성(int matchCount, boolean isMatchBonus, String expected) {
        LottoRank lottoRank = LottoRank.valueOf(matchCount, isMatchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(expected));
    }
}
