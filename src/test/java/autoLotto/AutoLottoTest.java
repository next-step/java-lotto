package autoLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutoLottoTest {
    @DisplayName("주어진 횟수만큼 로또 번호가 생성된다.")
    @Test
    void generateLottos() {
        int TEST_COUNT = 5;
        AutoLotto autoLotto = new AutoLotto(TEST_COUNT);
        assertEquals(TEST_COUNT, autoLotto.getNumbers().size());
    }
}
