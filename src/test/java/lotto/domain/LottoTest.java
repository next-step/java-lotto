package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    void 로또자동발급확인() {
        Lotto lotto = Lotto.autoGenerate();
        assertThat(lotto.numbers().getValues().size()).isEqualTo(6);
        assertAll(
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(0))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(1))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(2))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(3))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(4))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(5))).isTrue()
        );
    }

    @Test
    void 당첨확인() {
        String input = "7, 14, 21, 22, 44, 45";
        Lotto lotto = new Lotto(getNumbersForTest(input));

        String winInput = "1, 2, 7, 11, 40, 44";
        WinLotto winLotto = new WinLotto(getNumbersForTest(winInput));

        int matchingCount = lotto.checkMatchingNumbers(winLotto);
        assertThat(matchingCount).isEqualTo(2);
    }

    private static Numbers getNumbersForTest(String input) {
        List<Integer> inputNumbers = InputView.makeNumbers(input);
        Numbers numbers = new Numbers(inputNumbers);
        return numbers;
    }
}
