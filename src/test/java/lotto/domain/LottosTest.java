package lotto.domain;

import lotto.exception.PrizeOverFlowIsNegativeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottosTest {

    private final Lotto lottoHitAll = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::createLottoNumber)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFive = new Lotto(IntStream.rangeClosed(2, 7)
            .mapToObj(LottoNumber::createLottoNumber)
            .collect(Collectors.toList()));

    private final Lotto lottoHitFour = new Lotto(IntStream.rangeClosed(3, 8)
            .mapToObj(LottoNumber::createLottoNumber)
            .collect(Collectors.toList()));

    @Test
    @DisplayName("로또 금액 여부를 확인한다")
    void 로또_당첨_금액_확인() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(2000, 0);
        Lottos lottos = Lottos.createLottos(purchaseInfo, purchaseAmount -> List.of(lottoHitAll));

        Assertions.assertThat(lottos.getResultStatistic(new WinningLotto(lottoHitAll, LottoNumber.createLottoNumber(7))).getTotalPrize()).isEqualTo(2_000_000_000);

    }

    @Test
    @DisplayName("1등 2번 당첨된 경우 오버플로 발생하여 음수가 되는지 확인")
    void 로또_당첨_오버플로() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(2000, 0);
        Lottos lottos = Lottos.createLottos(purchaseInfo, purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThatThrownBy(
                        () -> lottos.getResultStatistic(new WinningLotto(lottoHitAll, LottoNumber.createLottoNumber(7))).getTotalPrize()
                ).isInstanceOf(PrizeOverFlowIsNegativeException.class)
                .hasMessage("당첨금 계산 중 오버플로 발생");

    }

    @Test
    @DisplayName("1등 ,3등에 당첨되었을 때 총 상금을 초과하는지 확인")
    void 로또_상금_초과() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(2000, 0);
        Lottos lottos = Lottos.createLottos(purchaseInfo, purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);
        lottos.additionalLotto(lottoHitFive);

        Assertions.assertThatThrownBy(
                        () -> lottos.getResultStatistic(new WinningLotto(lottoHitAll, LottoNumber.createLottoNumber(7))).getTotalPrize()
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 상금 20억을 넘길 순 없음");

    }

    @Test
    @DisplayName("5개(2~6) + 보너스 번호(1) 맞출 시 2등 금액이 수령되는지")
    void 로또_2등_상금() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1000, 0);
        Lottos lottos = Lottos.createLottos(purchaseInfo, purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(new WinningLotto(lottoHitFive, LottoNumber.createLottoNumber(1))).getTotalPrize()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("4개 + 보너스 번호 맞출 시 4등 금액 정상 수령 되는지")
    void 로또_2등_제외_보너스번호_상금_테스트() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1000, 0);
        Lottos lottos = Lottos.createLottos(purchaseInfo, purchaseAmount -> new ArrayList<>());

        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(new WinningLotto(lottoHitFour, LottoNumber.createLottoNumber(1))).getTotalPrize()).isEqualTo(50000);
    }

}
