package lotto;

import lotto.factory.LottoFactory;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsumerTest {

    @Test
    @DisplayName("통합 테스트")
    void integrationTest() {
        int purchaseAmount = 1000;


        LottoNumbers lottoNumbers = LottoNumbersFactory.manualCreateNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = LottoFactory.manualCreateSingleLotto(lottoNumbers);

        LottoWinner lottoWinner = new LottoWinner(
                LottoNumbersFactory.manualCreateNumberList("1, 2, 3, 4, 5, 10"),
                LottoNumberFactory.manualCreateNumber(6)
        );

        LottoReport report = LottoStore.report(lotto, lottoWinner);

        float rateOfRevenue = report.calculateRateOfRevenue(purchaseAmount);
        assertThat(rateOfRevenue).isEqualTo(30000.0f);
    }
}