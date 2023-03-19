package lottotest.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingEnumTest {

    private LottoRank rankingtest;

    @Test
    @DisplayName(value = "랭킹출력")
    void printrank() {
        System.out.println(rankingtest.findRank(6, false));
        System.out.println(rankingtest.findRank(5, true));
    }

    @Test
    @DisplayName(value = "전체출력")
    void print() {
        for (LottoRank rankingtest : rankingtest.values()) {
            System.out.println(rankingtest.toString());
        }
    }

}
