package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1. 금액을 입력받아 로또의 개수를 출력한다.
 * 2. 로또를 입력받아 로또를 출력한다.
 * 3. 일차하는 개수와 수익률을 입력받아 출력한다.
 */
public class OutputViewTest {
    private OutputView outputView;
    private Lotto lotto;

    @BeforeEach
    void init() {
        outputView = new OutputView();
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 구매 금액을 입력했을 경우 출력값 성공 테스트")
    @Test
    void right_price_input_test() {
        outputView.lottoAmountPrint(14);
        assertThat(outputView.getResult()).isEqualTo("14개를 구매했습니다.");
    }

    @DisplayName("로또를 입력받았을 때 출력값 성공 테스트")
    @Test
    void lotto_print() {
        outputView.lottoPrint(lotto);
        assertThat(outputView.getResult()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("일치하는 수와 수익률을 입력받아을 때 출력값 성공 테스트")
    @Test
    void winning_count_and_profit_pring() {
        outputView.winningPrint(Arrays.asList(1, 0, 0, 0), 0.35);
    }
}
