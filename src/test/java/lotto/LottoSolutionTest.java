package lotto;

import lotto.domain.dto.WinningLottoRequest;
import lotto.view.DosFakeResultView;
import lotto.view.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoSolutionTest {
    @DisplayName("runTest")
    @CsvSource(value = {
            "100000000000000|1,2,3,4,5,6|7|1",
            "100000000000000|1 ,2, 3,4,5 ,6|7|1"
    }, delimiter = '|')
    @ParameterizedTest
    public void runTest(long longMoney, String strWinningNumbers, int bonusNumber, int testSize) {
        assertThatCode(() -> {
            for (int testCounter = 0; testCounter < testSize; testCounter++) {
                new LottoSolution(
                        new FakeInputView(
                                longMoney,
                                new WinningLottoRequest(strWinningNumbers, bonusNumber)
                        ),
                        new DosFakeResultView()
                ).run();
            }
        }).doesNotThrowAnyException();
    }
}