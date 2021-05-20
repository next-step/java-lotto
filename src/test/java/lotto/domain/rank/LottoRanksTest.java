package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRanksTest {
    @Test
    @DisplayName("로또 랭킹들은 여러개의 로또 랭킹을 가지고, 몇개를 갖고 있는지 알 수 있다")
    public void 로또_랭킹들은_여러개의_로또_랭킹을_까지고_몇개를_갖고_있는지_알_수_있다() {
        List<LottoRank> lottoRankList = Arrays.asList(
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.SECOND,
                LottoRank.SECOND,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.THIRD,
                LottoRank.THIRD,
                LottoRank.FOURTH,
                LottoRank.FOURTH
        );


        LottoRanks lottoRanks = LottoRanks.createByList(lottoRankList);

        assertThat(lottoRanks.countOf(LottoRank.FIRST))
                .isEqualTo(5L);
        assertThat(lottoRanks.countOf(LottoRank.SECOND))
                .isEqualTo(4L);
        assertThat(lottoRanks.countOf(LottoRank.THIRD))
                .isEqualTo(3L);
        assertThat(lottoRanks.countOf(LottoRank.FOURTH))
                .isEqualTo(2L);
        assertThat(lottoRanks.countOf(LottoRank.MISS))
                .isEqualTo(0L);
    }
}
