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

    @Test
    @DisplayName("수익률 테스트 한장 구매 시 3등으로 테스트하므로 300.0")
    void 수익률_테스트() {

        PurchaseInfo purchaseInfo = new PurchaseInfo(1, 0);
        Lottos lottos = Lottos.createAutoLottos(purchaseInfo.getNumberOfAutoPurchase(), purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);

        LottoResultStatistic resultStatistic = lottos.getResultStatistic(new WinningLotto(lottoHitFive, LottoNumber.of(10)));

        Assertions.assertThat(resultStatistic.calculateProfit(5000)).isEqualTo(300.0);
    }

}
