package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    @DisplayName("당첨되지 않은 경우")
    void noWinning() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", 7);
        Lotto nonWinningLotto1 = Lotto.createManual(List.of(7, 8, 9, 10, 11, 12));
        Lotto nonWinningLotto2 = Lotto.createManual(List.of(13, 14, 15, 16, 17, 18));

        List<Lotto> purchasedLottos = Arrays.asList(nonWinningLotto1, nonWinningLotto2);
        LottoResult lottoResult = LottoResult.of(purchasedLottos, winningLotto);

        assertThat(lottoResult.calculateReturnRate()).isZero();
    }

    @Test
    @DisplayName("4등 당첨 1개, 나머지 당첨 안 된 경우")
    void singleWinning() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", 7);
        Lotto fourthRankLotto = Lotto.createManual(List.of(1, 2, 3, 4, 8, 9));
        Lotto nonWinningLotto = Lotto.createManual(List.of(10, 11, 12, 13, 14, 15));

        List<Lotto> purchasedLottos = Arrays.asList(fourthRankLotto, nonWinningLotto);
        LottoResult lottoResult = LottoResult.of(purchasedLottos, winningLotto);

        long expectedPrize = LottoRank.FOURTH.getPrize();
        int purchaseAmount = purchasedLottos.size() * LottoSeller.PRICE;
        double expectedReturnRate = (double) expectedPrize / purchaseAmount;

        assertThat(lottoResult.calculateReturnRate()).isEqualTo(expectedReturnRate);
    }

    @Test
    @DisplayName("여러 등수 당첨 테스트")
    void multipleWinnings() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", 7);

        Lotto firstRankLotto = Lotto.createManual(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = Lotto.createManual(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = Lotto.createManual(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourthRankLotto = Lotto.createManual(List.of(1, 2, 3, 4, 7, 8));
        Lotto fifthRankLotto = Lotto.createManual(List.of(1, 2, 3, 7, 8, 9));
        Lotto nonWinningLotto = Lotto.createManual(List.of(1, 2, 7, 8, 9, 10));

        List<Lotto> purchasedLottos = Arrays.asList(
                firstRankLotto, secondRankLotto, thirdRankLotto, fourthRankLotto, fifthRankLotto, nonWinningLotto);
        LottoResult lottoResult = LottoResult.of(purchasedLottos, winningLotto);

        long expectedPrize = LottoRank.RANK_WITH_PRIZE.stream().mapToLong(LottoRank::getPrize).sum();
        int purchaseAmount = purchasedLottos.size() * LottoSeller.PRICE;
        double expectedReturnRate = (double) expectedPrize / purchaseAmount;

        assertThat(lottoResult.calculateReturnRate()).isEqualTo(expectedReturnRate);
    }
}
