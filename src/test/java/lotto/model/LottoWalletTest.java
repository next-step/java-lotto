package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWalletTest {

    @Test
    void 수익_계산(){
        LottoWallet lottoWallet = new LottoWallet(
                List.of(
                        new Lotto(List.of(1,2,3,4,5,6)),
                        new Lotto(List.of(1,2,3,4,5,8)),
                        new Lotto(List.of(1,2,3,4,9,10)),
                        new Lotto(List.of(1,2,3,11,12,16)),
                        new Lotto(List.of(1,2,13,14,15,16))
                )
        );
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new Lotto(List.of(1,2,3,4,5,6)));

        int profit = lottoWallet.calculateProfit(lottoWinningNumber);

        assertThat(profit).isEqualTo(2000000000 + 1500000 + 50000 + 5000 + 0);
    }

}
