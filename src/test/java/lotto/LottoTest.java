package lotto;

import lotto.data.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.service.LottoGame.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 금액에맞춰_로또개수_발급() {
        assertThat(getAmountOfLotto(14000)).isEqualTo(14);
    }

    @Test
    void 로또번호_발급() {
        assertThat(new Lotto().getNumbers()).hasSize(6);
    }

    @Test
    void 당청번호_유효성체크() {
        List<Integer> winningNumbers = List.of(1, 2, 2, 4, 5, 6);
        assertThatIllegalArgumentException().isThrownBy(() -> checkWinningNumbers(winningNumbers));
    }

    @Test
    void 당첨번호와_몇개일치() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(matchWinningNumbers(winningNumbers, new Lotto(List.of(1, 2, 8, 9, 10, 11)))).isEqualTo(2);
    }

    @Test
    void 로또리스트의_당첨개수() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(2, 3, 7, 8, 9, 10)));

        assertThat(getWinningNumberList(winningNumbers, lottoList).get(2)).isEqualTo(1);
    }

    @Test
    void 수익() {
        assertThat(getReturnAmount(3)).isEqualTo(5000);
    }


    @Test
    void 수익률() {
        int returnValue = 140000;
        int purchaseAmout = 14000;
        assertThat(getRateOfReturn(returnValue, purchaseAmout)).isEqualTo("10.00");
    }

}
