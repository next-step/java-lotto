package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class LottoShopTest {

    @Test
    @DisplayName("수동 티켓 수가 총 티켓 수를 초과하면 예외 발생한다")
    void validateManualLottoAmountTest_manualGtTotal() {
        // given
        LottoShop lottoShop = new LottoShop();
        Money price = new Money(2000); // 총 2장 구매 가능
        List<LottoTicket> manualTickets = List.of(
                toTicket(List.of(1, 2, 3, 4, 5, 6)),
                toTicket(List.of(1, 2, 3, 4, 5, 7)),
                toTicket(List.of(1, 2, 3, 4, 5, 10))
        ); // 3장

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoShop.sellLotto(price, manualTickets));
    }

    LottoTicket toTicket(List<Integer> numbers) {
        return new LottoTicket(numbers.stream().map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

}
