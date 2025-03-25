package lotto;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoSeller;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void noWinning() {
        Lotto winningLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto nonWinningLotto1 = Lotto.create(List.of(7, 8, 9, 10, 11, 12));
        Lotto nonWinningLotto2 = Lotto.create(List.of(13, 14, 15, 16, 17, 18));

        List<Lotto> purchasedLottos = Arrays.asList(nonWinningLotto1, nonWinningLotto2);
        LottoResult lottoResult = LottoResult.from(purchasedLottos, winningLotto);

        assertThat(lottoResult.getReturnRate()).isZero();
    }

    @Test
    void singleWinning() {
        // 4등 당첨 1개, 나머지 당첨 안 된 경우
        Lotto winningLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdRankLotto = Lotto.create(List.of(1, 2, 3, 7, 8, 9));
        Lotto nonWinningLotto = Lotto.create(List.of(10, 11, 12, 13, 14, 15));

        List<Lotto> purchasedLottos = Arrays.asList(thirdRankLotto, nonWinningLotto);
        LottoResult lottoResult = LottoResult.from(purchasedLottos, winningLotto);

        long expectedPrize = LottoRank.FOURTH.getPrize();
        int purchaseAmount = purchasedLottos.size() * LottoSeller.PRICE;
        double expectedReturnRate = (double) expectedPrize / purchaseAmount;

        assertThat(lottoResult.getReturnRate()).isEqualTo(expectedReturnRate);
    }

    @Test
    void multipleWinnings() {
        // 여러 등수 당첨 테스트
        Lotto winningLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto firstRankLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = Lotto.create(List.of(1, 2, 3, 4, 7, 8));
        Lotto nonWinningLotto = Lotto.create(List.of(10, 11, 12, 13, 14, 15));

        List<Lotto> purchasedLottos = Arrays.asList(firstRankLotto, secondRankLotto, thirdRankLotto, nonWinningLotto);
        LottoResult lottoResult = LottoResult.from(purchasedLottos, winningLotto);

        long expectedPrize = LottoRank.FIRST.getPrize() + LottoRank.SECOND.getPrize() + LottoRank.THIRD.getPrize();
        int purchaseAmount = purchasedLottos.size() * LottoSeller.PRICE;
        double expectedReturnRate = (double) expectedPrize / purchaseAmount;

        assertThat(lottoResult.getReturnRate()).isEqualTo(expectedReturnRate);
    }
}
