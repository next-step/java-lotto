package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoShopTest {

    private LottoShop lottoShop;
    private List<String> manualLottoNumbers;

    @BeforeEach
    void init() {
        lottoShop = new LottoShop();
        manualLottoNumbers = Arrays.asList(
                "1,2,3,4,5,6",
                "1,2,3,4,5,45",
                "1,2,3,4,44,45",
                "1,2,3,43,44,45",
                "1,2,42,43,44,45");
    }

    @Test
    @DisplayName("구매 금액에 따라 정확한 개수 구매 테스트")
    void buy_lotto_test() {
        // given
        int money = 14000;
        LottoMoney lottoMoney = new LottoMoney(money);
        LottoTicketCount lottoTicketCount = new LottoTicketCount.Builder()
                .lottoMoney(lottoMoney)
                .manualLottoCount(manualLottoNumbers.size())
                .build();

        // when
        PublishedLottoTicket publishedLottoTicket = lottoShop.buyLotto(lottoTicketCount, manualLottoNumbers);

        // then
        assertThat(publishedLottoTicket.getPublishedLottoTicket()).hasSize(money / 1000);
    }

    @Test
    @DisplayName("구매 금액 0 또는 음수 테스트")
    void zero_or_negative_money_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoMoney zeroMoney = new LottoMoney(0);
            lottoShop.buyLotto(new LottoTicketCount.Builder()
                    .lottoMoney(zeroMoney)
                    .build(), manualLottoNumbers);

            LottoMoney negativeMoney = new LottoMoney(-1000);
            lottoShop.buyLotto(new LottoTicketCount.Builder()
                    .lottoMoney(negativeMoney)
                    .build(), manualLottoNumbers);
        }).withMessageMatching("금액이 부족합니다. 로또를 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("구매 금액이 천원 단위가 아닌 경우 테스트")
    void not_divided_by_1000_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoMoney notEnoughMoney = new LottoMoney(500);
            lottoShop.buyLotto(new LottoTicketCount.Builder()
                    .lottoMoney(notEnoughMoney)
                    .build(), manualLottoNumbers);
        }).withMessageMatching("금액이 부족합니다. 로또를 구매할 수 없습니다.");
    }

}
