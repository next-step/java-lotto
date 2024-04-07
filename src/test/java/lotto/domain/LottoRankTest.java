package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("당첨번호 매칭")
    void 당첨번호_매칭() {
        LottoRank result = LottoRank.of(6, false);
        assertThat(result).isEqualTo(LottoRank.FIRST);
    }
}
