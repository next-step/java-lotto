package lotto.domain;

import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("돈의 금액을 가지고 로또를 얼마나 살 수 있는지 확인")
    void calculateLottoAmount() {
        LottoMoney lottoMoney = new LottoMoney(5000);
        int amount = lottoService.calculateLottoAmount(lottoMoney);
        assertEquals(5, amount);
    }

    @Test
    @DisplayName("구매한 로또 리스트를 정상적으로 생성했는지 확인")
    void generateLottoNumbers() {
        int amount = 3;
        List<LottoNumbers> lottos = lottoService.generateLottoNumbers(amount);
        assertEquals(3, lottos.size());

        for (LottoNumbers lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
            assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45));
        }
    }

    @Test
    @DisplayName("맞춘 개수만큼 우승 상금을 반환하는지 확인")
    void getTotalWinningAmount() {
        List<LottoNumbers> userLottos = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int totalWinningAmount = lottoService.getTotalWinningAmount(0, userLottos, winningNumbers);

        assertEquals(WinningPrize.SIX.getPrizeMoney(), totalWinningAmount);
    }

    @Test
    @DisplayName("로또 숫자 5개와 보너스 볼 숫자가 같을 때 30,000,000 상금을 타는지 확인")
    void matchBonusBall() {
        List<LottoNumbers> userLottos = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 45));
        int bonusBall = 6;
        int totalWinningAmount = lottoService.getTotalWinningAmount(bonusBall, userLottos, winningNumbers);

        assertEquals(WinningPrize.FIVE_WITH_BONUS.getPrizeMoney(), totalWinningAmount);
    }

}
