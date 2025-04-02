package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoShopTest {
    static final int PRICE_PER_TICKET = 1000;

    @Test
    @DisplayName("구매 금액이 0보다 작으면 예외를 반환한다.")
    void validatePriceTest_priceLtZero() {
        int input = -1;
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoShop(input, lottoAutoGenerator))
                .withMessageContaining("로또 구매 가능 가격은 0원 이상입니다.");
    }

    @Test
    @DisplayName("구매 금액으로 살 수 있는 로또 갯수를 반환한다(로또 1장의 가격은 1000원이다.)")
    void calculateTicketAmount() {
        int input = 14000;
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();

        LottoShop lottoShop = new LottoShop(input, lottoAutoGenerator);

        assertEquals(input / PRICE_PER_TICKET, lottoShop.getTicketAmount());
    }

}
