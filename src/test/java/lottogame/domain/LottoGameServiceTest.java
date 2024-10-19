package lottogame.domain;

import lottogame.domain.lotto.LottoPurchase;
import lottogame.domain.lotto.Lottos;
import lottogame.domain.lotto.Rank;
import lottogame.domain.lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottoGameServiceTest {

    private LottoGameService lottoGameService;

    @BeforeEach
    void setUp() {
        int buyAmount = 5000;
        int manualLottoCount = 2;
        List<String> manualLottoNumbers = Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,7");
        lottoGameService = new LottoGameService(buyAmount, manualLottoCount, manualLottoNumbers);
    }

    @DisplayName("로또 구매 정보를 생성한다.")
    @Test
    void createPurchase() {
        LottoPurchase actual = lottoGameService.getLottoPurchase();

        assertEquals(2, actual.getManualCount());
        assertEquals(3, actual.getAutoCount());
        assertEquals(5000, actual.getTotalAmount());
    }

    @DisplayName("구매한 로또 번호를 생성한다.")
    @Test
    void createLottos() {
        Lottos actual = lottoGameService.getLottos();

        assertEquals(5, actual.getLottos().size());
    }

    @DisplayName("당청 로또를 생성한다.")
    @Test
    void createWinningLotto() {
        String winningNumbers = "1,2,3,4,5,6";
        int bonusNumber = 7;

        WinningLotto actual = lottoGameService.createWinningLotto(winningNumbers, bonusNumber);

        assertNotNull(actual.getWinningLotto());
        assertEquals(7, actual.getBonusNumber().getNumber());
    }

    @DisplayName("당첨 결과를 계산한다.")
    @Test
    void calculateWinningResults() {
        WinningLotto lotto = lottoGameService.createWinningLotto("1,2,3,4,5,6", 7);

        Map<Rank, Integer> actual = lottoGameService.calculateWinningResults(lotto);

        assertThat(actual).contains(
                entry(Rank.FIRST, 1),
                entry(Rank.SECOND, 1)
        );
    }

    @DisplayName("상금 비율을 계산한다.")
    @Test
    void calculatePrizeRate() {
        WinningLotto lotto = lottoGameService.createWinningLotto("1,2,3,4,5,6", 7);

        double actual = lottoGameService.calculatePrizeRate(lotto);
        double expected = (double) 2_030_000_000 / 5000;

        assertEquals(expected, actual);
    }


}
