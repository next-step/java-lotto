package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyLottoTest {

    @Test
    public void 보너스번호_확인() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(i + 1);
        }
        LuckyLotto luckyLotto = new LuckyLotto (numbers, 7);
        assertThat(luckyLotto.getBonusNumber()).isEqualTo(7);
    }
}
