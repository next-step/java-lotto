package lotto;

import lotto.domain.Number;
import lotto.exception.LottoNumberException;
import lotto.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputInfoTest {

    @Test
    void 수동3개_자동3개() {
        Number price = new Number("15000");
        Number manualCount = new Number("10");
        Number autoCount = new Number("5");
        InputInfo inputInfo = new InputInfo(price, manualCount);
        Assertions.assertThat(inputInfo.getManualCount()).isEqualTo(manualCount);
        Assertions.assertThat(inputInfo.getAutoCount()).isEqualTo(autoCount);
    }

    @Test
    void 구매오류() {
        Number price = new Number("500");
        Number manualCount = new Number("10");
        Assertions.assertThatThrownBy(() -> new InputInfo(price, manualCount)).isInstanceOf(LottoNumberException.class);
    }

}
