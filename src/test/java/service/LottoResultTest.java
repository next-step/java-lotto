package service;

import domain.Currency;
import domain.Lotto;
import domain.LottoPrize;
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
    public void afterEach(){
        userLottoRepository.clearStore();
    }

    @Test
    @DisplayName("당첨 번호와 각 로또 번호를 매칭해 당첨 결과를 출력한다.")
    void printResultTest() {
        Lotto winningNum = new Lotto(1, 2, 3, 4, 5, 6);
        userLottoRepository.saveUserLottoTickets(new Lotto(1,2,3,4,5,6));

        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);
        Map<LottoPrize, Integer> allResult = result.getAllResult();
        Set<LottoPrize> prizes = allResult.keySet();

        assertThat(prizes.stream().findFirst().get()).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    @DisplayName("구입 금액 대비 총 당첨금액 수익률을 계산해 출력한다.")
    void printReturnRateTest() {
        Lotto winningNum = new Lotto(1, 2, 3, 4, 5, 6);
        userLottoRepository.saveUserLottoTickets(new Lotto(1,2,3,11,22,33));
        LottoGameResultRepository result = lottoResultService.matchUserLotto(winningNum);

        float rate = lottoResultService.calculateReturnRate(5000, result, Optional.of(Currency.KOREA));

        assertThat(rate).isEqualTo(1);
    }
}
