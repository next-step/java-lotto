package lotto.view;


import lotto.vo.LottoWinningNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputViewTest {
    @Test
    public void 지난주당첨번호패턴체크() {
        String inputValue = "1, 2, 3, 4, 5, 6";
        String[] numbers = LottoInputView.splitLottoNumbers(inputValue);
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호패턴체크실패1() {
        String inputValue = "1, 2 3, 4, 5, 6";
        LottoInputView.splitLottoNumbers(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호패턴체크실패2() {
        String inputValue = "1, 2, 3, 4, 5, ";
        LottoInputView.splitLottoNumbers(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주당첨번호개수안맞음() {
        String inputValue = "1, 2, 3, 4";
        LottoInputView.splitLottoNumbers(inputValue);
    }

    @Test
    public void 당첨로또번호생성() {
        LottoWinningNumber lottoWinningNumber = LottoInputView.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"}, 7);
        assertThat(lottoWinningNumber.getWinningNumber()).hasSize(6);
        assertThat(lottoWinningNumber.getBonusNumber().getNumber()).isEqualTo(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨로또번호중복() {
        LottoInputView.createWinningNumbers(new String[]{"1", "1", "1", "1", "1", "1"}, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨로또번호중복2() {
        LottoInputView.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"}, 1);
    }
}