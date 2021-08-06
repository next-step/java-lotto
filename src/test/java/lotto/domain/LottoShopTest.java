package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 구매 테스트")
public class LottoShopTest {

    @Test
    @DisplayName("구매한 로또 개수 확인")
    void buyLottoCountTest() {
        // given
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoShop lottoShop = new LottoShop(1000);

        // when
        LottoTickets lottoTickets = lottoShop.buy(10_000L, lottoGenerator);
        int actual = lottoTickets.size();

        // then
        assertThat(actual).isEqualTo(10);
    }
}
