package lotto.domain;


import lotto.view.LottoView;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoViewTest {
    @Test
    public void 지난주당첨번호패턴체크() {
        String inputValue = "1, 2, 3, 4, 5, 6";
        String[] numbers = LottoView.splitWinningNumbers(inputValue);
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호패턴체크실패1() {
        String inputValue = "1, 2 3, 4, 5, 6";
        LottoView.splitWinningNumbers(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호패턴체크실패2() {
        String inputValue = "1, 2, 3, 4, 5, ";
        LottoView.splitWinningNumbers(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호개수안맞음() {
        String inputValue = "1, 2, 3, 4";
        LottoView.splitWinningNumbers(inputValue);
    }
}