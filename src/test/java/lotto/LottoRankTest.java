package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRankTest {

    @Test
    public void 파라미터가_LottoRank의_countOfMatch와_같다면_그_타입_반환() {
        LottoRank lottoRank = LottoRank.valueOf(3, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }


    @Test
    public void 보너스번호가_같고_당첨번호가_5개_2등_반환() {
        LottoRank lottoRank = LottoRank.valueOf(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    public void 보너스번호가_다르고_당첨번호가_5개_3등_반환() {
        LottoRank lottoRank = LottoRank.valueOf(5, false);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }
}