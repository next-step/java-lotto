package lotto.auto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    @DisplayName("키값으로 일치한 번호 3~6개를 입력한 경우 당첨금을 반환한다")
    void findPrizeMoneyByMatchCount() {
        int prizeMoneyByMatchCount = Rank.findPrizeMoneyByMatchCount(3);
        Assertions.assertThat(prizeMoneyByMatchCount).isEqualTo(5_000);

        prizeMoneyByMatchCount = Rank.findPrizeMoneyByMatchCount(4);
        Assertions.assertThat(prizeMoneyByMatchCount).isEqualTo(50_000);

        prizeMoneyByMatchCount = Rank.findPrizeMoneyByMatchCount(5);
        Assertions.assertThat(prizeMoneyByMatchCount).isEqualTo(1_500_000);

        prizeMoneyByMatchCount = Rank.findPrizeMoneyByMatchCount(6);
        Assertions.assertThat(prizeMoneyByMatchCount).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("키값으로 일치한 번호 0~2개를 입력한 경우 예외를 던진다")
    void findPrizeMoneyByMatchCountException() {
        Assertions.assertThatThrownBy(() -> Rank.findPrizeMoneyByMatchCount(0))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("key not found.");

        Assertions.assertThatThrownBy(() -> Rank.findPrizeMoneyByMatchCount(1))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("key not found.");

        Assertions.assertThatThrownBy(() -> Rank.findPrizeMoneyByMatchCount(2))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("key not found.");
    }
}
