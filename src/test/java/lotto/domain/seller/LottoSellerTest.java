package lotto.domain.seller;

import lotto.domain.strategy.RandomGenerationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoSellerTest {

    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        lottoSeller = LottoSeller.of(new RandomGenerationStrategy(6));
    }

    @DisplayName("로또 1장의 가격보다 낮은 금액을 내면 예외가 발생")
    @Test
    void buyTicketFailureByLackMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoSeller.buyTicket(1000 - 1));
    }
}
