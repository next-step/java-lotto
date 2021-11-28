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
}
