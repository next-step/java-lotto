package lottotest.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.enums.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankingEnumTest {


    @Test
    @DisplayName(value = "랭킹출력")
    void checkRanking() {
        assertThat(LottoRank.findRank(6, false)).isEqualTo(FIRST);
        assertThat(LottoRank.findRank(5, true)).isEqualTo(SECOND);
    }

    @Test
    @DisplayName(value = "전체출력")
    void print() {
        for (LottoRank rankingtest : LottoRank.values()) {
            System.out.println(rankingtest.toString());
        }
    }

}