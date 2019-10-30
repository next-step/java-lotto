package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 보너스 번호와 관련 된 로직이 있음
 */
public class LottoLotteryTest {

    private List<Integer> lottoWinningNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoWinningNumbers.add(0, 2);
        lottoWinningNumbers.add(1, 6);
        lottoWinningNumbers.add(2, 10);
        lottoWinningNumbers.add(3, 27);
        lottoWinningNumbers.add(4, 31);
        lottoWinningNumbers.add(5, 42);

        LottoWinningNumbers.LOTTO_BONUS_NUMBER = lottoWinningNumbers.get(5);

    }

    @DisplayName("보너스 당첨 여부 확인")
    @Test
    void purchasedLottoCompareBonusNumber() {
        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            LottoLottery.purchasedLottoCompareBonusNumber(lottoWinningNumbers, i);
        }
        assertThat(LottoLottery.bonusCheck).isEqualTo(true);
    }
}
