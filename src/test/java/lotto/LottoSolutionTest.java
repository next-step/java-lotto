package lotto;

import lotto.view.DosInputView;
import lotto.view.DosResultView;
import lotto.view.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoSolutionTest {
    @CsvSource(value = {
            "100000000|1,2,3,4,5,6"
    }, delimiter = '|')
    @DisplayName("runTest")
    @ParameterizedTest
    public void runTest(int intMoney, String strPrizeNumbers) {
        new LottoSolution(new FakeInputView(intMoney, strPrizeNumbers), new DosResultView()).run();
    }
}