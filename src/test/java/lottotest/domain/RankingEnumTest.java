package lottotest.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.enums.LottoRank.FIRST;
import static lotto.domain.enums.LottoRank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class RankingEnumTest {


    @Test
    @DisplayName(value = "랭킹출력")
    void checkRanking() {
        assertThat(LottoRank.findRank(6, false)).isEqualTo(FIRST);
        assertThat(LottoRank.findRank(5, true)).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("수익률 테스트")
    public void calculateRate(){

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 1);
        result.put(LottoRank.SECOND, 0);
        result.put(LottoRank.THIRD, 0);
        result.put(LottoRank.FOURTH, 0);
        result.put(LottoRank.FIFTH, 0);
        result.put(LottoRank.MISS, 0);

        // 실제 구입금액 10,000원 대비 일등 당첨액 2000,000,000
        assertThat(LottoRank.calculateRate(result, 10000)).isEqualTo(2000000000/10000);
    }

}