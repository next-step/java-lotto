package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구매 가격이 주어졌을 때 몇 개의 로또를 구매했는지 반환하는 로직 검증")
    @Test
    void lottoCountByAmountTest() {
        int amount = 14_000;
        int expectedCount = 14;
        assertThat(new Money(amount).getLottoCount()).isEqualTo(expectedCount);
    }

    @DisplayName("Money와 Result가 주어졌을 때 해당 결과에 맞는 수익률이 반환되는지 검증")
    @Test
    void ratioTest() {
        Result result = new Result();
        result.add(Rank.FIFTH);

        Money purchasedAmount = new Money(14000);

        assertThat(purchasedAmount.calculateRatio(result.calculateWinningAmount())).isEqualTo(0.35);
    }
}
