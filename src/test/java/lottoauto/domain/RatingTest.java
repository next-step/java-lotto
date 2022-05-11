package lottoauto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatingTest {
    @Test
    void Rating_생성() {
        assertThat(Rating.from(0)).isEqualTo(Rating.MISS);
        assertThat(Rating.from(1)).isEqualTo(Rating.MISS);
        assertThat(Rating.from(3)).isEqualTo(Rating.FIFTH);
        assertThat(Rating.from(4)).isEqualTo(Rating.FOURTH);
        assertThat(Rating.from(5)).isEqualTo(Rating.THIRD);
        assertThat(Rating.from(6)).isEqualTo(Rating.FIRST);
    }

    @Test
    void Rating_생성_보너스_번호_추가() {
        assertThat(Rating.valueOf(6, false)).isEqualTo(Rating.FIRST);
        assertThat(Rating.valueOf(5, true)).isEqualTo(Rating.SECOND);
        assertThat(Rating.valueOf(5, false)).isEqualTo(Rating.THIRD);
    }
}