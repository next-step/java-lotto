package step3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 수동 로또를 입력받는다.
 */
public class ManualLottoTest {

    @DisplayName("수동 로또를 입력받는다.")
    @Test
    void createLottoTest() {
        String str = "1,2,3,4,5,6";
        ManualLotto lotto = new ManualLotto();
        lotto.addManualLotto(str);

        assertThat(lotto.getLottoList()).containsExactly()
    }
}
