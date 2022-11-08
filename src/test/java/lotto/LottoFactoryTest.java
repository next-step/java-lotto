package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoFactoryTest {

    @Test
    void 수동_로또_생성() {
        LottoFactory.createManualLotto(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void 최소값1보다_작은수_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoFactory.createManualLotto(Arrays.asList(0,2,3,4,5,6))
        );
    }

    @Test
    void 최대값45보다_작은수_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoFactory.createManualLotto(Arrays.asList(1,2,3,4,5,46))
        );
    }

    @Test
    void 자동_로또_생성() {
        Lotto lotto = LottoFactory.createAutoLotto();
        Assertions.assertThat(lotto.getSize()).isEqualTo(6);
    }

    public void createTestLotto() {

    }

}
