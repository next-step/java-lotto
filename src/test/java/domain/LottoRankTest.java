package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    public void 보상맞는지확인() {

        assertThat(LottoRank.FIRST_PRICE.getPriceRewards()).isEqualTo(2000000000);
        assertThat(LottoRank.SECOND_PRICE.getPriceRewards()).isEqualTo(1500000);
        assertThat(LottoRank.THIRD_PRICE.getPriceRewards()).isEqualTo(50000);
        assertThat(LottoRank.FOURTH_PRICE.getPriceRewards()).isEqualTo(5000);
//        assertThat(LottoRank.FIFTH_PRICE.getPriceRewards()).isEqualTo(0);
//        assertThat(LottoRank.SIXTH_PRICE.getPriceRewards()).isEqualTo(0);
//        assertThat(LottoRank.SEVENTH_PRICE.getPriceRewards()).isEqualTo(0);
    }

}