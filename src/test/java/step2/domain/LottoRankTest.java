package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("LottoRank valueOf 테스트")
    void LottoRank_valueOf_TEST() {
        LottoRank one = LottoRank.valueOf(6, true);
        assertThat(one).isEqualTo(LottoRank.ONE);

        LottoRank two = LottoRank.valueOf(5, true);
        assertThat(two).isEqualTo(LottoRank.TWO);

        LottoRank three = LottoRank.valueOf(5, false);
        assertThat(three).isEqualTo(LottoRank.THREE);

        LottoRank four = LottoRank.valueOf(4, true);
        assertThat(four).isEqualTo(LottoRank.FOUR);

        LottoRank five = LottoRank.valueOf(3, true);
        assertThat(five).isEqualTo(LottoRank.FIVE);

    }
}