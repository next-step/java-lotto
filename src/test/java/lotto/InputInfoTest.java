package lotto;

import lotto.exception.LottoNumberException;
import lotto.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputInfoTest {

    @Test
    @DisplayName("로또 구매 금액에 맞게 여러장의 로또를 구입한다.")
    void getLotto() {
        InputInfo inputInfo = new InputInfo("5000");
        Assertions.assertThat(inputInfo.getLottoCount()).isEqualTo(5);
    }

    @Test
    void 당첨번호_숫자변환_오류() {
        InputInfo inputInfo = new InputInfo("1000");
        Assertions.assertThatThrownBy(() -> inputInfo.getAnswer("숫자아닌값")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 당첨번호_개수_오류() {
        InputInfo inputInfo = new InputInfo("1000");
        Assertions.assertThatThrownBy(() -> inputInfo.getAnswer("1,2")).isInstanceOf(LottoNumberException.class);
    }

}
