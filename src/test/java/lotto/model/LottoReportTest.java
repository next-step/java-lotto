package lotto.model;

import lotto.factory.LottoFactory;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoReportTest {

    @Test
    @DisplayName("수익률 계산")
    void calculateRateOfRevenue() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.manualCreateNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = LottoFactory.manualCreateSingleLotto(lottoNumbers);
        LottoNumber bonus = LottoNumberFactory.manualCreateNumber(7);
        LottoWinner winner = new LottoWinner(LottoNumbersFactory.manualCreateNumberList("1, 2, 3, 11, 12, 13"), bonus);

        LottoReport report = new LottoReport(lotto, winner);

        float rateOfRevenue = report.calculateRateOfRevenue(1000);
        assertThat(rateOfRevenue).isEqualTo(5);

    }
}