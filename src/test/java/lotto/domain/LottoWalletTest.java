package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWalletTest {

    @DisplayName("당첨번호가 6,5,4,3개 일치했을때 각각 수익률이 상금/투자금 인지")
    @ParameterizedTest
    @CsvSource({"10000, 6, 200000",
            "10000, 5, 150",
            "10000, 4, 5",
            "10000, 3, 0.5",
    })
    void get_profit_rate_when_fourth(final int money, final int matchCount, final float expectedProfitRate) {
        //given
        LottoWallet lottoWallet = new LottoWallet(money);

        //when
        lottoWallet.addLottoResult(LottoResult.findByMatchCount(matchCount));
        double profitRate = lottoWallet.getProfitRate();

        //then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
