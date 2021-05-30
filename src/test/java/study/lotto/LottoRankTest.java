package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoRank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("당첨 목록 내림차순 출력")
    @Test
    public void winningPrizeValuesTest() {
        List<LottoRank> lottoRankList = Arrays.asList(LottoRank.values());

        assertThat(lottoRankList).containsExactly(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND,
                LottoRank.FIRST);
    }

    @DisplayName("등수당 일치 개수, 당첨금액 확인")
    @Test
    public void winningPrizeTest() {
        assertThat(LottoRank.FOURTH.matchCount()).isEqualTo(3);
        assertThat(LottoRank.FOURTH.prize()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(LottoRank.FIRST.matchCount()).isEqualTo(6);
        assertThat(LottoRank.FIRST.prize()).isEqualTo(BigDecimal.valueOf(2000000000));
    }

}
