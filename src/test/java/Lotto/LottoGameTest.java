package Lotto;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoGameTest {

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        UserLotto userLotto = new UserLotto();
        List<Lotto> lottoTicket = userLotto.generateRandomLottoTickets(2000);

        for (Lotto lotto : lottoTicket) {
            System.out.println("lotto1.getLottoNumbers() = " + lotto.getLottoNumbers());
        }
        assertThat(lottoTicket.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 번호를 6개 미만으로 입력하는 경우 오류가 발생한다.")
    void invalidInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("ArrayList()의 Contains 함수를 활용하여 당첨 번호를 체크한다.")
    void matchWinningNumbers() {
        Lotto lotto = new Lotto("1, 2,3,4,5,6");

        UserLotto userLotto = new UserLotto(lotto);
        LottoGame lottoGame = new LottoGame(userLotto);
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);

        Map<Integer, Integer> lottoPrizeIntegerMap = lottoGame.matchNumbers(winningLotto);
        assertThat(lottoPrizeIntegerMap.get(6).intValue()).isEqualTo(1);
    }

}
