package lotto;

import common.model.Number;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ConsumerTest {

    @Test
    @DisplayName("자동 로또 통합 테스트")
    void autoLottoIntegrationTest() {
        int purchaseAmount = 1000;

        LottoNumbers lottoNumbers = LottoNumbersFactory.createByInput("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Collections.singletonList(lottoNumbers));

        LottoWinner lottoWinner = LottoNumbersFactory.createWinner("1, 2, 3, 4, 5, 10", LottoNumberFactory.createByNumber(6));

        Map<LottoRank, Number> result = lotto.matchAll(lottoWinner);

        float rateOfRevenue = LottoStore.calculateRateOfRevenue(result, purchaseAmount);
        assertThat(rateOfRevenue).isEqualTo(30000.0f);
    }

    @Test
    @DisplayName("수동, 자동 로또 통합 테스트")
    void mixLottoIntegrationTest() {
        int purchaseAmount = 2000;
        int manualLottoCount = 1;

        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.add(LottoNumbersFactory.createByInput("1, 2, 3, 4, 5, 6"));
        }

        Lotto lotto = LottoStore.ticket(purchaseAmount, manualLottoNumbers);
        LottoWinner lottoWinner = LottoNumbersFactory.createWinner("1, 2, 3, 4, 5, 10", LottoNumberFactory.createByNumber(6));

        Map<LottoRank, Number> result = lotto.matchAll(lottoWinner);

        assertThat(result.get(LottoRank.SECOND)).isEqualTo(new Number(1));

    }
}