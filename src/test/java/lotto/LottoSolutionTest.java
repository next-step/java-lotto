package lotto;

import lotto.domain.dto.LottoBuyInfo;
import lotto.domain.dto.WinningLottoInfo;
import lotto.view.DosFakeResultView;
import lotto.view.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoSolutionTest {
    @DisplayName("runTest")
    @ValueSource(ints = {
            1
    })
    @ParameterizedTest
    public void runTest(int testSize) {
        assertThatCode(() -> {
            for (int testCounter = 0; testCounter < testSize; testCounter++) {
                new LottoSolution(
                        new FakeInputView(
                                new LottoBuyInfo(1000000000L, Arrays.asList("1,2,3,4,5,6", "1,3,4,5,6,7", "1,4,5,6,7,8")),
                                new WinningLottoInfo("2,3,9,11,13,15", 7)
                        ),
                        new DosFakeResultView()
                ).run();
            }
        }).doesNotThrowAnyException();
    }
}