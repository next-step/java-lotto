package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {

    @Test
    @DisplayName("로또갯수 매칭 1번에 따른 가격을 확인한다")
    void 로또매칭_확인() {
        LottoRank lottoRank = LottoRank.findMatchNumber(3);

        assertThat(lottoRank.sumPrize(1)).isEqualTo(5000);
    }
}
