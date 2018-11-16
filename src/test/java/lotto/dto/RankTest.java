package lotto.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {



    @Test
    public void Enum정상검테스트() {
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void Enum보너스검출테스트() {
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void EnumFirst검출테스트() {
        assertThat(Rank.valueOf(6,true)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void EnumThird검출테스트() {
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void EnumForth검출테스트() {
        assertThat(Rank.valueOf(4,true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void EnumFIFTH검출테스트() {
        assertThat(Rank.valueOf(3,true)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void EnumFIFTH검출테스트2() {
        assertThat(Rank.valueOf(1,true)).isEqualTo(Rank.MISS);
    }
}
