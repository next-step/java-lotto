package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRequestTest {

    @ParameterizedTest
    @CsvSource(value = {"15000:15", "1234:1", "10:0", "190000:190"}, delimiter = ':')
    void 구매_횟수(int money, int buyCount) {
        LottoRequest request = new LottoRequest(money, Collections.emptyList());
        assertThat(request.buyChance()).isEqualTo(buyCount);
    }

    @Test
    void 전부_자동_로또_번호_생성() {
        LottoRequest request = new LottoRequest(5000, Collections.emptyList());
        LottoWallet lottoWallet = request.buy();
        assertThat(lottoWallet.getLottoCount()).isEqualTo(5);

        for (Lotto lotto : lottoWallet) {
            assertThat(lotto.getLottoNumbers()).hasSize(6);
        }
    }

}
