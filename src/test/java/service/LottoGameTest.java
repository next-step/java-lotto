package service;

import domain.Lotto;
import domain.LottoPrize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import repository.UserLottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoGameTest {

    UserLottoRepository userLottoRepository;
    LottoResultService lottoGameService;

    @BeforeEach
    public void beforeEach() {
        userLottoRepository = new UserLottoRepository();
        lottoGameService = new LottoResultService(userLottoRepository);
    }

    @AfterEach
    public void afterEach(){
        userLottoRepository.clearStore();
    }


    @Test
    @DisplayName("ArrayList()의 Contains 함수를 활용하여 당첨 번호를 체크한다.")
    void matchWinningNumbersTest() {
        Lotto lotto = new Lotto("1, 2,3,4,5,6");
        userLottoRepository.saveUserLottoTickets(lotto);

        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        Map<LottoPrize, Integer> lottoPrizeIntegerMap = lottoGameService.matchUserLotto(winningLotto).getAllResult();

        assertThat(lottoPrizeIntegerMap.get(LottoPrize.FIRST)).isEqualTo(1);
    }
    @Test
    @DisplayName("당첨 번호가 1~45 사이 값이 아닌 경우 exception throw")
    void wrongWinningNumbersTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(1, 2, 3, 50, 5, 6));
    }
}
