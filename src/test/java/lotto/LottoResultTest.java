package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        int money = LottoRank.values().length * LottoGame.GAME_AMOUNT;
        lottoResult = new LottoResult(money);
    }

    @Test
    @DisplayName("lank 카운트를 하나씩 올리고 실제로 올라갔는지 확인한다.")
    void update() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.update(lottoRank.getCount(), lottoRank.isConsiderBonus());
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            assertThat(lottoResult.rankCount(lottoRank)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("수익률을 확인한다.")
    void profit() {
        double expectedYield = getExpectedYield();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.update(lottoRank.getCount(), lottoRank.isConsiderBonus());
        }

        assertThat(lottoResult.yield()).isEqualTo(expectedYield);
    }

    private double getExpectedYield() {
        int money = LottoRank.values().length * LottoGame.GAME_AMOUNT;
        int profit = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            profit += lottoRank.getMoney();
        }

        return (double) profit / money;
    }
}
