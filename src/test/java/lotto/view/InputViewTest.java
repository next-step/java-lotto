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

        assertThat(InputView.question(InputConstants.PURCHASE_QUESTION)).isEqualTo("14000");
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void input_winning_numbers(){
        InputUtil.mockInputStream("1, 2, 3, 4, 5, 6");

        assertThat(InputView.question(InputConstants.WINNING_NUMBERS_QUESTION)).isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    void input_bonus_numbers(){
        InputUtil.mockInputStream("19");

        assertThat(InputView.question(InputConstants.BONUS_NUMBER_QUESTION)).isEqualTo("19");
    }

    @Test
    @DisplayName("수동으로 구매할 로또 입력 테스트")
    void input_manual_lotto_count(){
        InputUtil.mockInputStream("3");

        assertThat(InputView.question(InputConstants.MANUAL_LOTTO_COUNT_QUESTION)).isEqualTo("3");
    }


    @Test
    @DisplayName("로또번호 수동 입력 테스트")
    void input_manual_lotto_numbers(){
        InputUtil.mockInputStream("8, 21, 23, 41, 42, 43");

        assertThat(InputView.question(InputConstants.MANUAL_LOTTO_NUMBERS_QUESTION))
                .contains("8")
                .contains("21")
                .contains("23")
                .contains("41");
    }

}