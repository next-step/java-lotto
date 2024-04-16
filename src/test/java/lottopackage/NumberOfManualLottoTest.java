package lottopackage;

import lottopackage.vo.LottoBall;
import lottopackage.vo.NumberOfManualLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfManualLottoTest {
    @Test
    @DisplayName("NumberOfManualLottoTest 정상적인 값")
    public void numberOfManualLottoTest() {
        NumberOfManualLotto numberOfManualLotto = new NumberOfManualLotto(1);
        Assertions.assertThat(numberOfManualLotto.getNumberOfManualLotto()).isEqualTo(1);
    }

    @Test
    @DisplayName("NumberOfManualLottoTest 비정상적인 값")
    public void wrongNumberOfManualLottoTest() {
        Assertions.assertThatThrownBy(() -> {
            new NumberOfManualLotto(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
