package lotto.view;

import lotto.mock.InputUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("구입금액 입력 테스트")
    void input_sale_amount(){
        InputUtil.mockInputStream("14000");

        assertThat(InputView.setSaleAmount()).isEqualTo(14000);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void input_winning_numbers(){
        InputUtil.mockInputStream("1, 2, 3, 4, 5, 6");

        assertThat(InputView.setWinningNumbers()).isEqualTo("1, 2, 3, 4, 5, 6");
    }

}