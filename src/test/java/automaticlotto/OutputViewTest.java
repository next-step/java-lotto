package automaticlotto;

import automaticlotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @DisplayName("구매한 로또 갯수")
    @Test
    void showLottoNumberTest() {
        assertThat(OutputView.showLottoNumber(8500)).isEqualTo(8);
    }
}
