package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 구매 갯수를 구한다.")
    @Test
    public void getBuyLottoNumber() {
        //given
        int amount = 14000;
        Seller seller = new Seller();

        //when
        int buyLottoNumber = seller.getBuyLottoNumber(amount);

        //then
        assertThat(buyLottoNumber).isEqualTo(14);
    }

    @DisplayName("로또를 생성할때 숫자 6개가 나온다.")
    @Test
    public void getLottoNumbers() {
        //given
        Lotto lotto = new Lotto();

        //when & then
        assertThat(lotto.getNumberSize()).isEqualTo(6);
    }

    @DisplayName("입력받은 당첨 번호와 현재 로또 번호를 비교한다.")
    @Test
    public void compareWinLottoNumbersAndCurrentLottoNumbers() {
        //given
        List<Integer> winNumbersInput = List.of(1, 2, 3, 4, 10, 6);
        Lotto winNumber = new Lotto(winNumbersInput);

        List<Integer> currentNumbers = List.of(1, 2, 3, 7, 9, 10);
        Lotto currentNumber = new Lotto(currentNumbers);

        //when
        long matchedCount = currentNumber.compareWinNumber(winNumber);

        //then
        assertThat(matchedCount).isEqualTo(4L);
    }
}
