package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {


    @DisplayName("당첨개수 확인")
    @Test
    public void checkPrizeTest() {
        //given
        PurchasedLottos purchasedLottos = new PurchasedLottos(generatePurchaseLottos());
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningLotto winningLotto = new WinningLotto(lotto,bonusNumber);

        //when
        WinningResult winningResult = WinningResult.of(purchasedLottos, winningLotto);

        //then
        assertThat(winningResult.value().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(winningResult.value().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(winningResult.value().get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(winningResult.value().get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(winningResult.value().get(LottoRank.FIFTH)).isEqualTo(1);
    }

    private List<Lotto> generatePurchaseLottos() {
        List<Lotto> PurchasedLottos = new ArrayList<>();
        PurchasedLottos.add(new Lotto("1,2,3,4,5,6"));
        PurchasedLottos.add(new Lotto("1,2,3,4,5,7"));
        PurchasedLottos.add(new Lotto("1,2,3,4,5,16"));
        PurchasedLottos.add(new Lotto("1,12,3,14,15,6"));
        return PurchasedLottos;
    }


    @DisplayName("총 상금 확인")
    @Test
    void WinningLottoPrizeTest() {
        //given
        PurchasedLottos purchasedLottos = new PurchasedLottos(generatePurchaseLottos());
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningLotto winningLotto = new WinningLotto(lotto,bonusNumber);

        //when
        WinningResult winningResult = WinningResult.of(purchasedLottos, winningLotto);

        //then
        BigDecimal totalPrize = LottoRank.FIFTH.prize();
        totalPrize = totalPrize.add(LottoRank.THIRD.prize());
        totalPrize = totalPrize.add(LottoRank.SECOND.prize());
        totalPrize = totalPrize.add(LottoRank.FIRST.prize());
        assertThat(winningResult.totalPrize()).isEqualTo(totalPrize);
    }
}
