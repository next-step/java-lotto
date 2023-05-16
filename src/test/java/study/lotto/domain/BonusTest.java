package study.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BonusTest {

    @Test
    void 보너스볼은_지난주_로또_정답번호와_중복일_수_없음() {
        List<Integer> lastWeekNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> {
                    Bonus bonus = new Bonus(6, lastWeekNumbers);
                }).isInstanceOf(RuntimeException.class);
    }
}
