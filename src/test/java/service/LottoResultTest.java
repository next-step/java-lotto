package service;

import domain.Currency;
import domain.Lotto;
import domain.LottoPrize;
import domain.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.LottoGameResultRepository;
import repository.UserLottoRepository;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    UserLottoRepository userLottoRepository;
    LottoResultService lottoResultService;

    @BeforeEach
    public void beforeEach() {
        userLottoRepository = new UserLottoRepository();
        lottoResultService = new LottoResultService(userLottoRepository);
    }

    @AfterEach
    public void afterEach() {
        userLottoRepository.clearStore();
    }

    @Test
    @DisplayName("6개를 모두 맞추는 경우 1등 상태가 된다.")
    void printFirstResultTest() {
        WinningLotto winningNum = new WinningLotto(1, 2, 3, 4, 5, 6, 7);
        userLottoRepository.saveUserLottoTickets(new Lotto(1, 2, 3, 4, 5, 6));

        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);
        Map<LottoPrize, Integer> allResult = result.getAllResult();
        Set<LottoPrize> prizes = allResult.keySet();

        System.out.println("allResult = " + allResult);

        assertThat(prizes.stream().findFirst().get()).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    @DisplayName("3개를 맞추는 경우 5등 상태가 된다.")
    void printFourthResultTest() {
        WinningLotto winningNum = new WinningLotto(1, 2, 3, 4, 5, 6, 7);
        userLottoRepository.saveUserLottoTickets(new Lotto(1, 2, 3, 11, 12, 13));

        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);
        Map<LottoPrize, Integer> allResult = result.getAllResult();
        Set<LottoPrize> prizes = allResult.keySet();

        assertThat(prizes.stream().findFirst().get()).isEqualTo(LottoPrize.FIFTH);
    }

    @Test
    @DisplayName("3개 미만 동일한 경우 NO MATCH 상태가 된다.")
    void printNoMatchResultTest() {
        WinningLotto winningNum = new WinningLotto(1, 2, 3, 4, 5, 6, 7);
        userLottoRepository.saveUserLottoTickets(new Lotto(1, 44, 3, 11, 12, 13));

        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);
        Map<LottoPrize, Integer> allResult = result.getAllResult();
        Set<LottoPrize> prizes = allResult.keySet();

        assertThat(prizes.stream().findFirst().get()).isEqualTo(LottoPrize.NO_MATCH);
    }

    @Test
    @DisplayName("구입 금액 대비 총 당첨금액 수익률을 계산해 출력한다.")
    void printReturnRateTest() {
        WinningLotto winningNum = new WinningLotto(1, 2, 3, 4, 5, 6, 7);
        userLottoRepository.saveUserLottoTickets(new Lotto(1, 2, 3, 11, 22, 33));
        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);

        float rate = lottoResultService.calculateReturnRate(5000, result, Optional.of(Currency.KRW));

        assertThat(rate).isEqualTo(1);
    }


    @Test
    @DisplayName("5개 일치가 일치하는 경우 3등 상태가 된다.")
    void fiveMatchesTest() {
        WinningLotto winningNum = new WinningLotto(9, 2, 3, 4, 5, 7, 10);
        userLottoRepository.saveUserLottoTickets(new Lotto(1, 2, 3, 4, 5, 7));

        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);
        Map<LottoPrize, Integer> allResult = result.getAllResult();
        Set<LottoPrize> prizes = allResult.keySet();

        assertThat(prizes.stream().findFirst().get()).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    @DisplayName("5개 일치+보너스번호가 일치하는 경우 2등 상태가 된다.")
    void fiveMatchesTestAndBonusTest() {
        WinningLotto winningNum = new WinningLotto(1, 2, 3, 4, 5, 8, 9);
        userLottoRepository.saveUserLottoTickets(new Lotto(1, 2, 3, 4, 5, 7));

        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);
        Map<LottoPrize, Integer> allResult = result.getAllResult();
        Set<LottoPrize> prizes = allResult.keySet();

        assertThat(prizes.stream().findFirst().get()).isEqualTo(LottoPrize.SECOND);
    }


}
