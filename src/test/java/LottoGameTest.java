import domain.Lotto;
import service.LottoGameService;
import repository.UserLottoRepository;
import domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoGameTest {

    @Test
    @DisplayName("당첨 번호를 6개 미만으로 입력하는 경우 Exception이 발생한다.")
    void invalidInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("ArrayList()의 Contains 함수를 활용하여 당첨 번호를 체크한다.")
    void matchWinningNumbers() {
        Lotto lotto = new Lotto("1, 2,3,4,5,6");

        UserLottoRepository userLotto = new UserLottoRepository(lotto);
        LottoGameService lottoGame = new LottoGameService(userLotto);
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);

        Map<Integer, Integer> lottoPrizeIntegerMap = lottoGame.matchUserLotto(winningLotto);
        assertThat(lottoPrizeIntegerMap.get(6).intValue()).isEqualTo(1);
    }

}
