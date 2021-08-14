package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 테스트")
public class LottoShopTest {

    private LottoGenerator lottoGenerator;
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoGenerator = new AutoLottoGenerator();
        lottoShop = new LottoShop(lottoGenerator);
    }

    @Test
    @DisplayName("구매한 로또 개수 확인")
    void buyLottoCountTest() {
        // given
        LottoTickets lottoTickets = lottoShop.buy(10_000L);

        // when
        int actual = lottoTickets.size();

        // then
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 수동 구매 확인")
    void buyManualLottoTicketTest() {
        // given
        LottoShop lottoShop = new LottoShop(lottoGenerator);

        // when
        LottoTickets lottoTickets = lottoShop.buy(2000, "1,2,3,4,5,6");
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();

        // then
        assertThat(lottoTicketList).contains(new LottoTicket("1", "2", "3", "4", "5", "6"));
    }

    @Test
    @DisplayName("로또를 살수 없는 금액이 입력될 경우 Exception")
    void buyValidateAmountMinimumExceptionTest() {
        assertThatThrownBy(() -> lottoShop.buy(800L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("less then the minimum amount");
    }

    @Test
    @DisplayName("입력한 수동 로또 개수의 가격보다 적은 금액이 입력될 경우 Exception")
    void buyNotEnoughAmountException() {
        // given
        String[] manualLottoTickets = {"1,2,3,4,5,6", "11,12,13,14,15,16"};
        LottoShop lottoShop = new LottoShop(lottoGenerator);

        //when
        //then
        assertThatThrownBy(() -> lottoShop.buy(1000L, manualLottoTickets))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not enough amount");
    }
}
