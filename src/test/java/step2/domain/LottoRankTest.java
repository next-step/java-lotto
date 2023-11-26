package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.LottoRank;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    public void checkRank() {
        assertThat(LottoRank.valueOf("FIRST")).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf("SECOND")).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf("THIRD")).isEqualTo(LottoRank.THIRD);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:ture:FOURTH", "3:false:FIFTH", "2:true:NONE"}, delimiter = ':')
    public void lottoRankTest(int matchCount, boolean matchBonus, String expected ) {
        assertThat(LottoRank.lottoRank(matchCount, matchBonus)).isEqualTo(LottoRank.valueOf(expected));
    }
}