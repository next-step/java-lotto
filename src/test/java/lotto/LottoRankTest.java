package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRankTest {

    @Test
    public void 파라미터가_LottoRank의_countOfMatch와_같다면_그_타입_반환() {
        LottoRank lottoRank = LottoRank.valueOf(3);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }




}