package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("count 와 rank 가 같으면 같은 객체다.")
    @Test
    void create() {
        assertThat(new LottoResult(1, Rank.FIRST))
                .isEqualTo(new LottoResult(1, Rank.FIRST));
    }

    @DisplayName("rank 별 lotto 당첨 금액 계산")
    @Test
    void calculateRewards() {
        assertThat(new LottoResult(2, Rank.SECOND).calculateRewards())
                .isEqualTo(BigDecimal.valueOf(Rank.SECOND.getRewards() * 2));
    }
}