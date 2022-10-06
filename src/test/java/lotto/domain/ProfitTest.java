package lotto.domain;

import lotto.domain.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @DisplayName("당첨 금액이 55000원이고 로또 구입 금액이 5000원이면 수익률은 11퍼센트이다.")
    @Test
    void profit() {
        Reward reward = new Reward(List.of(Rank.FIFTH, Rank.FOURTH, Rank.MISS, Rank.MISS, Rank.MISS));

        Profit profit = new Profit(reward);

        assertThat(profit.value()).isEqualTo(11.00);
    }

    @DisplayName("당첨 금액이 없으면 수익률은 0이다.")
    @Test
    void zeroProfit() {
        Reward reward = new Reward(List.of(Rank.MISS, Rank.MISS, Rank.MISS));

        Profit profit = new Profit(reward);

        assertThat(profit.value()).isEqualTo(0);
    }
}