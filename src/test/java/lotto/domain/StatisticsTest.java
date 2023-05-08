package lotto.domain;

import lotto.model.request.ReqManualLotto;
import lotto.service.gernerator.ManualLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StatisticsTest {

    private final ManualLottoNumbersGenerator manualLottoNumbersGenerator = new ManualLottoNumbersGenerator();


    @Test
    @DisplayName("수익률 테스트 - 손해")
    void getProfitLoseTest() {
        List<String> requestLottoNumber = List.of("1,12,13,14,15,16");
        List<String> winnerLottoNumber = List.of("1,2,3,4,5,7");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(requestLottoNumber)));
        LottoNumbers winnerLottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(winnerLottoNumber));
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(11);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);


        Statistics statistics = new Statistics(winnerLotto, lotto,Money.wons(14000));

        assertAll(
                () -> assertThat(statistics.provideProfit()).isLessThan(1.0)
        );

    }

    @Test
    @DisplayName("수익률 테스트 - 본전")
    void getProfitPrincipalTest() {
        List<String> requestLottoNumber = List.of("1,2,3,14,15,16");
        List<String> winnerLottoNumber = List.of("1,2,3,4,5,7");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(requestLottoNumber)));
        LottoNumbers winnerLottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(winnerLottoNumber));
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(11);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);


        Statistics statistics = new Statistics(winnerLotto, lotto,Money.wons(5000));

        assertAll(
                () -> assertThat(statistics.provideProfit()).isEqualTo(1.0)
        );

    }


    @Test
    @DisplayName("수익률 테스트 - 수익")
    void getProfitTest() {
        List<String> requestLottoNumber = List.of("1,2,3,4,5,16");
        List<String> winnerLottoNumber = List.of("1,2,3,4,5,7");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(requestLottoNumber)));
        LottoNumbers winnerLottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(winnerLottoNumber));
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(11);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);


        Statistics statistics = new Statistics(winnerLotto, lotto,Money.wons(5000));

        assertAll(
                () -> assertThat(statistics.provideProfit()).isGreaterThan(1.0)
        );

    }

}