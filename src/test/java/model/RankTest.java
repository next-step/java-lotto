package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @Test
    void 일치하는_개수에_해당하는_당첨_금액을_반환한다() {
        final Rank winningPrices = Rank.determine(2);

        assertThat(winningPrices).isEqualTo(Rank.NONE);
    }

    @Test
    void 일치하는_개수가_6개이면서_보너스_번호가_다르면_1등을_반환한다() {
        final Rank second = Rank.determine(6, false);
        
        assertThat(second).isEqualTo(Rank.FIRST);
    }

    @Test
    void 일치하는_개수가_5개이면서_보너스_번호도_같으면_2등을_반환한다() {
        final Rank second = Rank.determine(5, true);
        
        assertThat(second).isEqualTo(Rank.SECOND);
    }

    @Test
    void 일치하는_개수가_5개이면서_보너스_번호가_다르면_3등을_반환한다() {
        final Rank second = Rank.determine(5, false);
        
        assertThat(second).isEqualTo(Rank.THIRD);
    }

    @Test
    void 일치하는_개수가_4개이면서_보너스_번호가_다르면_4등을_반환한다() {
        final Rank second = Rank.determine(4, false);

        assertThat(second).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 일치하는_개수가_3개이면서_보너스_번호가_다르면_5등을_반환한다() {
        final Rank second = Rank.determine(3, false);

        assertThat(second).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 일치하는_개수가_2개이하이면서_보너스_번호가_다르면_등수가_없다(final int matchingCount) {
        final Rank second = Rank.determine(matchingCount, false);

        assertThat(second).isEqualTo(Rank.NONE);
    }
}
