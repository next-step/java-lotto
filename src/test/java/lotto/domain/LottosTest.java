package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private final Lotto lottoHitAll = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFive = new Lotto(IntStream.rangeClosed(2, 7)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFour = new Lotto(IntStream.rangeClosed(3, 8)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));

    @Test
    @DisplayName("로또 금액 여부를 확인한다")
    void 로또_당첨_금액_확인() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(2, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(),
                purchaseAmount -> List.of(lottoHitAll));

        Assertions.assertThat(lottos.getResultStatistic(
                new WinningLotto(lottoHitAll, LottoNumber.of(7))).getTotalPrize())
                .isEqualTo(Prize.FIRST.getValue());

    }

    @Test
    @DisplayName("5개(2~6) + 보너스 번호(1) 맞출 시 2등 금액이 수령되는지")
    void 로또_2등_상금() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(),
                purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                new WinningLotto(lottoHitFive, LottoNumber.of(1))).getTotalPrize())
                .isEqualTo(Prize.SECOND.getValue());
    }

    @Test
    @DisplayName("5개(2~6)를 맞추고 보너스를 못맞출 시 3등 금액이 수령되는지")
    void 로또_3등_상금() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(),
                purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                new WinningLotto(lottoHitFive, LottoNumber.of(9))).getTotalPrize())
                .isEqualTo(Prize.THIRD.getValue());

    }

    @Test
    @DisplayName("4개 + 보너스 번호 맞출 시 4등 금액 정상 수령 되는지")
    void 로또_2등_제외_보너스번호_맞춘경우_상금_테스트() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(),
                purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                new WinningLotto(lottoHitFour, LottoNumber.of(1))).getTotalPrize())
                .isEqualTo(Prize.FOURTH.getValue());

    }
    @Test
    @DisplayName("4개 + 보너스 번호 맞추지 못할 시 4등 금액 정상 수령 되는지")
    void 로또_2등_제외_보너스번호_못_맞춘경우_상금_테스트() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(),
                purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(
                new WinningLotto(lottoHitFour, LottoNumber.of(9))).getTotalPrize())
                .isEqualTo(Prize.FOURTH.getValue());

    }

}
