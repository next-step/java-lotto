package lotto.domian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.common.MessageSet.NOT_ENOUGH_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoShopTest {

    LottoShop lottoShop;
    LottoNumberGenerator generator;

    @BeforeEach
    public void setUP(){
        generator = mock(LottoNumberGenerator.class);
        lottoShop = LottoShop.of(generator);
    }

    @Test
    @DisplayName("금액으로 구입 가능한 최대 티켓을 생성")
    void whenGivenMoney_thenCreateMaximumPurchasableTickets() {
        LottoTickets tickets = lottoShop.generateLottoTickets(3000);
        assertThat(tickets.getLottoTickets().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("금액이 티켓값 보다 부족하면 exception 처리")
    void whenMoneyIsLessThanTicketPrice_thenThrowException() {
        assertThatThrownBy(()->{
            lottoShop.generateLottoTickets(500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ENOUGH_MONEY.getErrorMessage());
    }
}
