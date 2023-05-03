package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @Test
    void 지난주당첨번호() {
        WinLotto winLotto = new WinLotto(getNumbersForTest("1, 8, 11, 31, 41, 42"));

        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(8);
        expectedNumbers.add(11);
        expectedNumbers.add(31);
        expectedNumbers.add(41);
        expectedNumbers.add(42);

        Numbers numbers = new Numbers(expectedNumbers);

        assertThat(winLotto.numbers()).isEqualTo(numbers);
    }

    @Test
    void ToString() {
        WinLotto winLotto = new WinLotto(getNumbersForTest("1, 8, 11, 31, 41, 42"));

        String expectedToString = "[1, 8, 11, 31, 41, 42]";

        assertThat(winLotto.toString()).isEqualTo(expectedToString);
    }

    private static Numbers getNumbersForTest(String input) {
        List<Integer> inputNumbers = InputView.makeNumbers(input);
        Numbers numbers = new Numbers(inputNumbers);
        return numbers;
    }
}