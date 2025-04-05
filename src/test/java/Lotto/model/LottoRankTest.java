package Lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    void shouldBeSecondRank(){
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void shouldBeThirdRank(){
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void shouldBeFirstRank(){
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void shouldBeFifthRank(){
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void shouldBeMissRank(){
        assertThat(LottoRank.valueOf(0, true)).isEqualTo(LottoRank.MISS);
    }
}
