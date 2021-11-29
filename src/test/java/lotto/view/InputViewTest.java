package lotto.view;

import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    @DisplayName("입력받은 금액으로 로또 게임수를 계산한다.")
    void getLottoGameCount() {
        InputView inputView = new InputView(new InputPrice(10000));
        assertThat(inputView.getLottoGameCount()).isEqualTo(new LottoGameCount(10));
    }
}
