package lotto.domain.lotto;

import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoSeller 클래스 테스트")
public class LottoSellerTest {

    @DisplayName("Price만큼 LottoNumbers를 가진 LottoTicket을 발급할 수 있다.")
    @Test
    void buy() {
        int price = 10000;
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());

        LottoTicket lottoTicket = lottoSeller.buy(new Price(price));

        assertThat(lottoTicket.getLottoNumbers()).hasSize(price/Price.LOTTO_PRICE);
    }
}
