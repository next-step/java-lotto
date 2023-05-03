package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoTest {

    @Test
    void 로또자동발급확인() {
        MyLotto myLotto = MyLotto.auto();
        assertThat(myLotto.numbers().count()).isEqualTo(6);
        for (int i = 0; i < myLotto.numbers().count(); i++) {
            assertThat(LottoRule.NUMBER_RANGE.contains(myLotto.numbers().find(i))).isTrue();
        }
    }

    @Test
    void ToString() {
        String input = "1, 8, 11, 31, 41, 42";
        MyLotto myLotto = new MyLotto(getNumbersForTest(input));
        String expectedToString = "[1, 8, 11, 31, 41, 42]";
        assertThat(myLotto.toString()).isEqualTo(expectedToString);
    }

    @Test
    void 당첨확인() {
        String input = "7, 14, 21, 22, 44, 45";
        MyLotto myLotto = new MyLotto(getNumbersForTest(input));

        String winInput = "1, 2, 7, 11, 40, 44";
        WinLotto winLotto = new WinLotto(getNumbersForTest(winInput));

        myLotto.checkMatchingNumbers(winLotto);
        assertThat(myLotto.matchingCount()).isEqualTo(2);
    }

    private static Numbers getNumbersForTest(String input) {
        List<Integer> inputNumbers = InputView.makeNumbers(input);
        Numbers numbers = new Numbers(inputNumbers);
        return numbers;
    }
}
