package lotto;

import lotto.domain.Number;
import lotto.domain.Price;
import lotto.exception.InputValueException;
import lotto.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputInfoTest {

    @Test
    void 수동3개_자동3개() {
        Price price = Price.of("15000");
        Number manualCount = Number.of("10");
        Number autoCount = Number.of("5");
        InputInfo inputInfo = new InputInfo(price, manualCount);
        Assertions.assertThat(inputInfo.getManualCount()).isEqualTo(manualCount);
        Assertions.assertThat(inputInfo.getAutoCount()).isEqualTo(autoCount);
    }

    @Test
    void 구매오류() {
        Price price = Price.of("500");
        Number manualCount = Number.of("10");
        Assertions.assertThatThrownBy(() -> new InputInfo(price, manualCount)).isInstanceOf(InputValueException.class);
    }

    @Test
    void 수동만_구매() {
        Price price = Price.of("2000");
        Number manualCount = Number.of("2");
        InputInfo inputInfo = new InputInfo(price, manualCount);
        Assertions.assertThat(inputInfo.getManualCount().getNumber()).isEqualTo(2);
        Assertions.assertThat(inputInfo.getAutoCount().getNumber()).isEqualTo(0);
    }

}
