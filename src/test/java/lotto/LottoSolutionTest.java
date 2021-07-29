package lotto;

import lotto.view.DosFakeResultView;
import lotto.view.DosResultView;
import lotto.view.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSolutionTest {
    @CsvSource(value = {
            "10000000000000|1,2,3,4,5,6"
    }, delimiter = '|')
    @DisplayName("runTest")
    @ParameterizedTest
    public void runTest(long longMoney, String strPrizeNumbers) {
        new LottoSolution(new FakeInputView(longMoney, strPrizeNumbers), new DosFakeResultView()).run();
    }
}