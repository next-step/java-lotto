package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @RepeatedTest(100)
    void 랜덤_숫자를_잘_획득하는지_확인() {
        Lotto lotto = new Lotto(new LottoRules());
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 45);
        }

    }
}