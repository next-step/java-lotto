package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또자동발급확인() {
        Lotto lotto = Lotto.auto();
        assertThat(lotto.numbers().size()).isEqualTo(6);
        for(Integer number : lotto.numbers()){
            assertThat(LottoRule.NUMBER_RANGE.contains(number)).isTrue();
        }
    }

    @Test
    void 로또정보수동입력() {
        String inputNumbers = "1, 8, 11, 31, 41, 42";
        Lotto lastWinLottoInfo = Lotto.manual(inputNumbers);

        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(8);
        expectedNumbers.add(11);
        expectedNumbers.add(31);
        expectedNumbers.add(41);
        expectedNumbers.add(42);

        assertThat(lastWinLottoInfo.numbers()).isEqualTo(expectedNumbers);
    }

    @Test
    void ToString() {
        String inputNumbers = "1, 8, 11, 31, 41, 42";
        Lotto lastWinLottoInfo = Lotto.manual(inputNumbers);

        String expectedToString = "[1, 8, 11, 31, 41, 42]";

        assertThat(lastWinLottoInfo.toString()).isEqualTo(expectedToString);
    }
}
