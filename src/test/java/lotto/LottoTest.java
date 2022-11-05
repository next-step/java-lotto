package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 수동_로또_생성() {
        ManualLottoFactory.create(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void 최소값1보다_작은수_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoFactory.create(Arrays.asList(0,2,3,4,5,6))
        );
    }

    @Test
    void 최대값45보다_작은수_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoFactory.create(Arrays.asList(1,2,3,4,5,46))
        );
    }

}
