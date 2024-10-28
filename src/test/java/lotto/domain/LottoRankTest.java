package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"3,false,FIFTH", "3,true,FIFTH", "5,false,THIRD", "5,true,SECOND"}, delimiter = ',')
    public void 토또의_당첨개수가_맞으면_해당랭크가_반환된다(int count, boolean matchBonus, LottoRank result) {
        Rank rank = LottoRank.match(count, matchBonus);
        assertThat(rank).isEqualTo(result);
    }

    @Test
    public void 당첨되지_않으면_NONE을_반환한다() {
        Rank rank = LottoRank.match(2, false);
        assertThat(rank).isEqualTo(LottoRank.None.NONE);
    }
}
