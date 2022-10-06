package lotto.domain;

import lotto.domain.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    @DisplayName("당첨 금액을 알 수 있다.")
    @Test
    void reward() {
        Reward reward = new Reward(List.of(Rank.FIFTH, Rank.FOURTH));

        assertThat(reward.value()).isEqualTo(55000);
    }
}