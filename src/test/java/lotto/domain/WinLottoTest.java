package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @Test
    void 지난주당첨번호() {
        String inputNumbers = "1, 8, 11, 31, 41, 42";
        WinLotto winLotto = new WinLotto(inputNumbers);

        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(8);
        expectedNumbers.add(11);
        expectedNumbers.add(31);
        expectedNumbers.add(41);
        expectedNumbers.add(42);

        assertThat(winLotto.numbers()).isEqualTo(expectedNumbers);
    }

    @Test
    void ToString() {
        String inputNumbers = "1, 8, 11, 31, 41, 42";
        WinLotto winLotto = new WinLotto(inputNumbers);

        String expectedToString = "[1, 8, 11, 31, 41, 42]";

        assertThat(winLotto.toString()).isEqualTo(expectedToString);
    }
}