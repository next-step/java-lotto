package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LottoWalletTest {

    @Test
    void 결과_계산() {
        LottoWallet lottoWallet = new LottoWallet(
                List.of(
                        new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(Set.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(Set.of(1, 2, 3, 4, 5, 19)),
                        new Lotto(Set.of(1, 2, 3, 4, 9, 10)),
                        new Lotto(Set.of(1, 2, 3, 11, 12, 16)),
                        new Lotto(Set.of(1, 2, 13, 14, 15, 16))
                )
        );
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)), new LottoNumber(19));

        LottoResult lottoResult = lottoWallet.calculateResult(lottoWinningNumber);

        assertThat(lottoResult).isEqualTo(new LottoResult(List.of(
                LottoPrize.FIRST,
                LottoPrize.THIRD,
                LottoPrize.SECOND,
                LottoPrize.FOURTH,
                LottoPrize.FIFTH,
                LottoPrize.NONE
        )));
    }

}
