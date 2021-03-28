package lotto;

import lotto.domain.Lotto;
import lotto.domain.NumbersSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class LottoTest {
    @DisplayName("Lotto끼리 비교하여 같은숫자수 반환")
    @Test
    void countNumbers() {
        // GIVE
        String[] number = {"1", "2", "3", "4", "5", "6"};
        String[] otherNumber = {"1", "11", "3", "8", "5", "6"};
        Lotto lotto = new Lotto(new NumbersSelector(number));
        Lotto otherLotto = new Lotto(new NumbersSelector(otherNumber));
        // WHEN
        int hitNum = lotto.countNumbers(otherLotto);
        // THEN
        assertThat(hitNum).isEqualTo(4);
    }
}
