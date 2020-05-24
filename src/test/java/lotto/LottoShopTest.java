package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    @DisplayName("로또를 구입하고 크기를 검증한다.")
    void 로또_구입_테스트(){
        LottoShop lottoShop = new LottoShop();
        List<Lotto> lottoTickets = lottoShop.buy();

        assertThat(lottoTickets).hasSize(1);
    }
}
