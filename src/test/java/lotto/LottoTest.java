package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("Lotto끼리 비교하여 같은숫자수 반환")
    @Test
    void countNumbers() {
        // GIVE
        List<Number> number = Arrays.asList(new Number(1),new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        List<Number> otherNumber = Arrays.asList(new Number(1),new Number(2), new Number(3), new Number(4), new Number(5), new Number(8));
        Lotto lotto = new Lotto(number);
        Lotto otherLotto = new Lotto(otherNumber);
        // WHEN
        int hitNum = lotto.countNumbers(otherLotto);
        // THEN
        assertThat(hitNum).isEqualTo(5);
    }
}
