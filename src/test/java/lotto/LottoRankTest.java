package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("로또 매칭 결과 개수를 통해 LottoRank를 가져온다.")
    void 로또_매칭_랭크_테스트(){
        int count = 6;
        LottoRank lottoRank = LottoRank.valueOf(count);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
}
