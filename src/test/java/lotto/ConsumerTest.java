package lotto;

import common.model.Number;
import common.view.InputView;
import lotto.application.Constant;
import lotto.factory.LottoFactory;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ConsumerTest {

    @Test
    @DisplayName("자동 로또 통합 테스트")
    void autoLottoIntegrationTest() {
        int purchaseAmount = 1000;

        LottoNumbers lottoNumbers = LottoNumbersFactory.manualCreateSingleNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = LottoFactory.manualCreateSingleLotto(lottoNumbers);

        LottoWinner lottoWinner = LottoNumbersFactory.manualCreateWinner("1, 2, 3, 4, 5, 10", LottoNumberFactory.manualCreateNumber(6));

        Map<LottoRank, Number> result = lotto.matchAll(lottoWinner);

        float rateOfRevenue = LottoStore.calculateRateOfRevenue(result, purchaseAmount);
        assertThat(rateOfRevenue).isEqualTo(30000.0f);
    }

    @Test
    @DisplayName("수동, 자동 로또 통합 테스트")
    void mixLottoIntegrationTest(){
        int purchaseAmount = 2000;
        int manualLottoCount = 1;

        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualLottoNumbersInput = "1, 2, 3, 4, 5, 6";
            manualLottoNumbers.add(LottoNumbersFactory.manualCreateSingleNumbers(manualLottoNumbersInput));
        }

        Lotto lotto = LottoStore.mixTicket(purchaseAmount, manualLottoNumbers);
        LottoWinner lottoWinner = LottoNumbersFactory.manualCreateWinner("1, 2, 3, 4, 5, 10", LottoNumberFactory.manualCreateNumber(6));

        Map<LottoRank, Number> result = lotto.matchAll(lottoWinner);

        assertThat(result.get(LottoRank.SECOND)).isEqualTo(new Number(1));

    }
}