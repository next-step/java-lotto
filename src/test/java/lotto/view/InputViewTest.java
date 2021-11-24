package lotto.view;

import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    @DisplayName("입력받은 금액으로 로또 게임수를 계산한다.")
    public void getLottoGameCount() {
        InputView inputView = new InputView(new InputPrice(10000));
        assertThat(inputView.getLottoGameCount()).isEqualTo(new LottoGameCount(10));
    }

    @Test
    @DisplayName("지난 주 당첨 번호는 6개만 입력 받는다.")
    public void validLottoNumberLength() {
        String[] lottoMumber = "1,2,3,4,5,6,7".split(",");
        assertThatThrownBy(() -> {
            new InputView().validLottoNumberLength(lottoMumber);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("지난 주 당첨 번호는 6개만 입력할 수 있습니다.");
    }
}
