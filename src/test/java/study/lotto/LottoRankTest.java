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

        assertThat(lottoRankList).containsExactly(LottoRank.MISS, LottoRank.FIFTH,
                LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    }

    @DisplayName("5등 당첨")
    @Test
    public void rankFifth(){
        assertThat(LottoRank.FIFTH).isEqualTo(LottoRank.of(3, false));
        assertThat(LottoRank.FIFTH).isEqualTo(LottoRank.of(3, true));
    }

    @DisplayName("4등 당첨")
    @Test
    public void rankFourth(){
        assertThat(LottoRank.FOURTH).isEqualTo(LottoRank.of(4, false));
        assertThat(LottoRank.FOURTH).isEqualTo(LottoRank.of(4, true));
    }

    @DisplayName("3등 당첨")
    @Test
    public void rankThrid(){
        assertThat(LottoRank.THIRD).isEqualTo(LottoRank.of(5, false));
        assertThat(LottoRank.THIRD).isNotEqualTo(LottoRank.of(5, true));
    }

    @DisplayName("2등 당첨")
    @Test
    public void rankSecond(){
        assertThat(LottoRank.SECOND).isNotEqualTo(LottoRank.of(5, false));
        assertThat(LottoRank.SECOND).isEqualTo(LottoRank.of(5, true));
    }

    @DisplayName("1등 당첨")
    @Test
    public void rankFirst(){
        assertThat(LottoRank.FIRST).isEqualTo(LottoRank.of(6, false));
        assertThat(LottoRank.FIRST).isEqualTo(LottoRank.of(6, true));
    }

}
