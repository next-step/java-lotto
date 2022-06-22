package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoCountTest {
    @Test
    void create() {
        //given
        long manualLottoCount = 3L;

        //when
        ManualLottoCount result = new ManualLottoCount(manualLottoCount);

        //then
        assertThat(result).isEqualTo(new ManualLottoCount(manualLottoCount));
    }

    @Test
    void createMinus() {
        //given
        long minusLottoCount = -3L;

        //then
        assertThatThrownBy(() -> new ManualLottoCount(minusLottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isBiggerThan() {
        //given
        long count = 3;
        ManualLottoCount manualLottoCount1 = new ManualLottoCount(3);
        ManualLottoCount manualLottoCount2 = new ManualLottoCount(4);

        //when
        boolean result1 = manualLottoCount1.isBiggerThan(count);
        boolean result2 = manualLottoCount2.isBiggerThan(count);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }
}
