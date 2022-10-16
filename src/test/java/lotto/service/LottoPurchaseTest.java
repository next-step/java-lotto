package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

    private LottoPurchaseService lottoPurchaseService;

    @BeforeEach
    void setUp() {
        this.lottoPurchaseService = new LottoPurchaseService();
    }

    @DisplayName("Money를 넘기면 1000원짜리 로또를 몇개 구입했는지 반환한다.")
    @Test
    void lotto_purchase_count() {
        assertThat(lottoPurchaseService.purchaseNumber(new Money(3000))).isEqualTo(new Amount(3));
    }
}
