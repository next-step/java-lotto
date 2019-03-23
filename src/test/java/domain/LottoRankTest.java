package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoRankTest {

    @Test
    public void findMatchCount_none_Test() {
        assertThat(LottoRank.findMatchCount(2)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.findMatchCount(7)).isEqualTo(LottoRank.NONE);
    }

    @Test
    public void findMatchCount_three_Test() {
        assertThat(LottoRank.findMatchCount(3)).isEqualTo(LottoRank.THREE);
    }

    @Test
    public void findMatchCount_four_Test() {
        assertThat(LottoRank.findMatchCount(4)).isEqualTo(LottoRank.FOUR);
    }

    @Test
    public void findMatchCount_five_Test() {
        assertThat(LottoRank.findMatchCount(5)).isEqualTo(LottoRank.FIVE);
    }

    @Test
    public void findMatchCount_six_Test() {
        assertThat(LottoRank.findMatchCount(6)).isEqualTo(LottoRank.SIX);
    }

    @Test
    public void 당첨금계산_3개일치_3장() {
        assertThat(LottoRank.THREE.calculatePrize(3)).isEqualTo(15_000);
    }

    @Test
    public void 당첨금계산_4개일치_1장() {
        assertThat(LottoRank.FOUR.calculatePrize(1)).isEqualTo(50_000);
    }

    @Test
    public void 당첨금계산_5개일치_2장() {
        assertThat(LottoRank.FIVE.calculatePrize(2)).isEqualTo(3_000_000);
    }

    @Test
    public void 당첨금계산_6개일치_1장() {
        assertThat(LottoRank.SIX.calculatePrize(1)).isEqualTo(2_000_000_000);
    }

    @Test
    public void 당첨금계산_2개일치_1장() {
        assertThat(LottoRank.NONE.calculatePrize(1)).isEqualTo(0);
    }
}