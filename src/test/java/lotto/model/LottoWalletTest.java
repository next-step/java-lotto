package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWalletTest {

    @Test
    void 결과_계산() {
        LottoWallet lottoWallet = new LottoWallet(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                        new Lotto(List.of(1, 2, 3, 11, 12, 16)),
                        new Lotto(List.of(1, 2, 13, 14, 15, 16))
                )
        );
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        LottoResult lottoResult = lottoWallet.calculateResult(lottoWinningNumber);

        assertThat(lottoResult).isEqualTo(new LottoResult(List.of(
                LottoPrize.FIRST,
                LottoPrize.SECOND,
                LottoPrize.THIRD,
                LottoPrize.FOURTH,
                LottoPrize.NONE
        )));
    }

}
