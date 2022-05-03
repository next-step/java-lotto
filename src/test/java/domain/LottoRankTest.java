package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    void 랭크머니에_해당하지_않는_금액_입력() {
        assertThatThrownBy(() -> {
            LottoRank.valueOf(1000);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}