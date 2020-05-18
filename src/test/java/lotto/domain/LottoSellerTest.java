package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSellerTest {

    @DisplayName("로또를 한개이상 구입할수있다.")
    @ParameterizedTest
    @CsvSource(value = {
        "1000,1",
        "2000,2",
        "3000,3"
    })
    void buy_many_lotto(long price, int count) {
        LottoSeller lottoSeller = new LottoSeller();
        LottoPaper lottoPaper = lottoSeller.sell(price);

        assertThat(lottoPaper.getCount()).isEqualTo(count);
    }
}
