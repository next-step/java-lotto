package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoShopException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.nextstep.lotto.domain.LottoTicketFixtures.LOTTO_TICKET_123456;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {
    @DisplayName("Money를 인자로 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Money money = new Money(10000L);

        assertThat(new LottoShop(money)).isNotNull();
    }

    @DisplayName("1000원 미만의 돈으로 객체 생성 시도시 예외 발생")
    @ParameterizedTest
    @ValueSource(longs = { 0, 111, 999 })
    void createFailTest(long notEnoughValue) {
        Money money = new Money(notEnoughValue);

        assertThatThrownBy(() -> new LottoShop(money)).isInstanceOf(InvalidLottoShopException.class);
    }

    @DisplayName("정해진 금액 내에서 수동으로 LottoTicket을 구매할 수 있다.")
    @Test
    void buyStaticLottoTicketTest() {
        Money money = new Money(10000L);
        LottoShop lottoShop = new LottoShop(money);
        int expectedSize = 1;

        lottoShop.buyStaticLottoTicket(LOTTO_TICKET_123456);

        assertThat(lottoShop.howManyStaticBoughtLottoTickets()).isEqualTo(expectedSize);
    }

    @DisplayName("정해진 금액을 넘어서 수동으로 LottoTicket 구매 시도 시 예외 발생")
    @Test
    void buyStaticLottoTicketFailTest() {
        Money money = new Money(2000L);
        LottoShop lottoShop = new LottoShop(money);
        lottoShop.buyStaticLottoTicket(LOTTO_TICKET_123456);

        assertThatThrownBy(() -> lottoShop.buyStaticLottoTicket(LOTTO_TICKET_123456))
                .isInstanceOf(InvalidLottoShopException.class);
    }

    @DisplayName("수동으로 구매하고 남은 LottoTicket을 자동으로 구매한다.")
    @Test
    void buyAutoLottoTicketsByRemainedMoneyTest() {
        Money money = new Money(10000L);
        LottoShop lottoShop = new LottoShop(money);
        lottoShop.buyStaticLottoTicket(LOTTO_TICKET_123456);

        LottoTickets lottoTickets = lottoShop.buyAutoLottoTicketsByRemainedMoney();

        assertThat(lottoTickets.size()).isEqualTo(10);
    }
}