package lotto.domain.enums;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoRankTest {

    @Test
    void 로또순위를_조회한다() {
        // given
        int hit = 3;
        boolean isHitBonus = false;

        //when
        LottoRank rank = LottoRank.findRank(hit, isHitBonus);

        //then
        assertThat(rank).isEqualTo(LottoRank.THREE_HIT);
    }
}
