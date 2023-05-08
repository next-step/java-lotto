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
        WinLotto winLotto = new WinLotto(new Numbers(InputView.makeNumbers("1, 8, 11, 31, 41, 42")));

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
    void 지난주당첨번호with보너스번호() {
        WinLotto winLotto = new WinLotto(new Numbers(InputView.makeNumbers("1, 3, 11, 13, 21, 23")), 31);

        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(3);
        expectedNumbers.add(11);
        expectedNumbers.add(13);
        expectedNumbers.add(21);
        expectedNumbers.add(23);

        Numbers numbers = new Numbers(expectedNumbers);

        assertAll(
                () -> assertThat(winLotto.numbers()).isEqualTo(numbers),
                () -> assertThat(winLotto.bonusNumber()).isEqualTo(31)
        );
    }
}