package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IputViewTest {
    @Test
    void 금액에대한_로또갯수_구하기() {
        InputView inputView = new InputView();
        int amount = 10000;
        assertThat(inputView.getLottoCnt(amount)).isEqualTo(10);
    }
}
