package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 테스트")
public class LottoShopTest {

    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        lottoShop = new LottoShop(lottoGenerator);
    }

    @Test
    @DisplayName("구매한 로또 개수 확인")
    void buyLottoCountTest() {
        LottoTickets lottoTickets = lottoShop.buy(10_000L);
        int actual = lottoTickets.size();
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("로또를 살수 없는 금액이 입력될 경우 Exception")
    void buyValidateAmountMinimumExceptionTest() {
        assertThatThrownBy(() -> lottoShop.buy(800L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("less then the minimum amount");
    }
}
