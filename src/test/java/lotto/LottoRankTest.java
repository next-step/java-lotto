package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoRank;

public class LottoRankTest {
    @Test
    @DisplayName("일치 갯수에 따른 상금 테스트")
    public void amountOfHit(){
        // given & when & then
        assertThat(LottoRank.of(3).amount()).isEqualTo(5000);
    }
}
