package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoRankTest {

    @Test
    public void findMatchCount_none_Test() {
        assertThat(LottoRank.findMatchCount(2, false)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.findMatchCount(7, false)).isEqualTo(LottoRank.MISS);
    }

    @Test
    public void findMatchCount_three_Test() {
        assertThat(LottoRank.findMatchCount(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    public void findMatchCount_4개일치() {
        assertThat(LottoRank.findMatchCount(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    public void findMatchCount_5개일치() {
        assertThat(LottoRank.findMatchCount(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    public void findMatchCount_5개일치_보너스_포함() {
        assertThat(LottoRank.findMatchCount(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    public void findMatchCount_5개일치_보너스_미포함() {
        assertThat(LottoRank.findMatchCount(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    public void findMatchCount_6개일치() {
        assertThat(LottoRank.findMatchCount(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    public void 당첨금계산_3개일치_3장() {
        assertThat(LottoRank.FIFTH.calculatePrize(3)).isEqualTo(15_000);
    }

    @Test
    public void 당첨금계산_4개일치_1장() {
        assertThat(LottoRank.FOURTH.calculatePrize(1)).isEqualTo(50_000);
    }

    @Test
    public void 당첨금계산_5개일치_2장() {
        assertThat(LottoRank.THIRD.calculatePrize(2)).isEqualTo(3_000_000);
    }

    @Test
    public void 당첨금계산_6개일치_1장() {
        assertThat(LottoRank.FIRST.calculatePrize(1)).isEqualTo(2_000_000_000);
    }

    @Test
    public void 당첨금계산_2개일치_1장() {
        assertThat(LottoRank.MISS.calculatePrize(1)).isEqualTo(0);
    }

}