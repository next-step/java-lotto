package lotto.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultStatisticTest {

    private final Lotto lottoHitAll = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFive = new Lotto(IntStream.rangeClosed(2, 7)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFour= new Lotto(IntStream.rangeClosed(3, 8)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));

    @Test
    @DisplayName("수익률 테스트 한장 구매 시 3등으로 테스트하므로 300.0")
    void 수익률_테스트() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(), purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);

        LottoResultStatistic resultStatistic = lottos.getResultStatistic(new WinningLotto(lottoHitFive, LottoNumber.of(10)));

        Assertions.assertThat(resultStatistic.calculateProfit(5000)).isEqualTo(300.0);
    }

    @Test
    @DisplayName("1등은 여러본 당첨되도 똑같은 금액을 수령한다")
    void 당첨금_테스트_1등_중복당첨() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(), purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                        new WinningLotto(lottoHitAll, LottoNumber.of(9))).getTotalPrize())
                .isEqualTo(Prize.FIRST.getValue());
    }

    @Test
    @DisplayName("2등은 여러번 당첨되도 똑같은 금액을 수령한다")
    void 당첨금_테스트_2등_중복당첨() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(), purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                        new WinningLotto(lottoHitFive, LottoNumber.of(1))).getTotalPrize())
                .isEqualTo(Prize.SECOND.getValue());
    }

    @Test
    @DisplayName("3등은 여러번 당첨되도 똑같은 금액을 수령한다")
    void 당첨금_테스트_3등_중복당첨() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(), purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                        new WinningLotto(lottoHitFive, LottoNumber.of(9))).getTotalPrize())
                .isEqualTo(Prize.THIRD.getValue());
    }

    @Test
    @DisplayName("4등은 여러번 당첨되면 당첨금액*개수 만큼 수령한다")
    void 당첨금_테스트_4등_중복당첨() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(), purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                        new WinningLotto(lottoHitFour, LottoNumber.of(9))).getTotalPrize())
                .isEqualTo(100000L);
    }




}
