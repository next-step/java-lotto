package lotto.domain.seller;

import lotto.domain.strategy.RandomGenerationStrategy;
import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoSellerTest {

    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        lottoSeller = LottoSeller.of(new RandomGenerationStrategy(LottoNumbers.LOTTO_NUMBER_SIZE));
    }

    @DisplayName("로또 1장의 가격보다 낮은 금액을 내면 예외가 발생")
    @Test
    void buyTicketFailureByLackMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoSeller.buyTicket(LottoSeller.ONE_TICKET_PRICE - 1));
    }

    @DisplayName("로또 구입 금액에 맞는 로또 티켓을 반환")
    @ParameterizedTest
    @ValueSource(ints = { 1000, 14000 })
    void buyTickets(final int money) {
        assertThat(lottoSeller.buyTicket(money).size())
                .isEqualTo(money / LottoSeller.ONE_TICKET_PRICE);
    }
}
