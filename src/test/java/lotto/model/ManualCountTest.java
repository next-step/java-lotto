package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.ManualCount.ERROR_MANUAL_COUNT_BIGGER_THAN_BUY_COUNT;
import static lotto.model.ManualCount.ERROR_MANUAL_COUNT_NOT_ALLOWED_NEGATIVE_NUMBER;

public class ManualCountTest {
    @Test
    void 수동_로또_번호_갯수를_저장한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            ManualCount manualCount = new ManualCount(3, new BuyAmount(12000));
        });
    }

    @Test
    void 수동_로또_번호_갯수면_음수가_오면_예외를_발생시킨다() {
        Assertions.assertThatThrownBy(() -> {
                    ManualCount manualCount = new ManualCount(-1, new BuyAmount(12000));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MANUAL_COUNT_NOT_ALLOWED_NEGATIVE_NUMBER);
    }

    @Test
    void 수동_로또_번호_갯수가_구입갯수를_초과하면_예외를_발생시킨다() {
        Assertions.assertThatThrownBy(() -> {
                    ManualCount manualCount = new ManualCount(13, new BuyAmount(12000));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MANUAL_COUNT_BIGGER_THAN_BUY_COUNT);
    }
    @Test
    void 로또_목록을_생성한다() {
        ManualCount manualCount = new ManualCount(2, new BuyAmount(3000));

        List<Lotto> actual = manualCount.createLotto(value -> new Lotto(1, 2, 3, 4, 5, 6));
        List<Lotto> expected = Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동_로또_번호_갯수를_출력한다() {
        ManualCount manualCount = new ManualCount(2, new BuyAmount(3000));
        int actual = manualCount.autoCount();
        Assertions.assertThat(actual).isEqualTo(1);
    }
}
