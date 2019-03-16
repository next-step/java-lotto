package lotto.domain;


import lotto.view.LottoInputView;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputViewTest {
    @Test
    public void 지난주당첨번호패턴체크() {
        String inputValue = "1, 2, 3, 4, 5, 6";
        String[] numbers = LottoInputView.splitWinningNumbers(inputValue);
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호패턴체크실패1() {
        String inputValue = "1, 2 3, 4, 5, 6";
        LottoInputView.splitWinningNumbers(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호패턴체크실패2() {
        String inputValue = "1, 2, 3, 4, 5, ";
        LottoInputView.splitWinningNumbers(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호개수안맞음() {
        String inputValue = "1, 2, 3, 4";
        LottoInputView.splitWinningNumbers(inputValue);
    }

    @Test
    public void 당첨로또번호생성() {
        List<Integer> winningNumbers = LottoInputView.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        assertThat(winningNumbers).hasSize(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨로또번호중복() {
        List<Integer> winningNumbers = LottoInputView.createWinningNumbers(new String[]{"1", "1", "1", "1", "1", "1"});
        assertThat(winningNumbers).hasSize(6);
    }
}