package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.LottoGenerator;
import step4.LottoLottery;
import step4.LottoNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoLotteryTest {

    private List<LottoNumber> lottoWinningNumbers = new ArrayList<>();
    private Map<Integer, Integer> resultMatching = new HashMap<>();

    @BeforeEach
    void setUp() {
        lottoWinningNumbers.add(0, new LottoNumber(2));
        lottoWinningNumbers.add(1, new LottoNumber(2));
        lottoWinningNumbers.add(2, new LottoNumber(10));
        lottoWinningNumbers.add(3, new LottoNumber(27));
        lottoWinningNumbers.add(4, new LottoNumber(31));
        lottoWinningNumbers.add(5, new LottoNumber(42));

        resultMatching.put(0, 5);
        resultMatching.put(1, 0);
        resultMatching.put(2, 0);

        LottoNumber.lottoBonusNumber = LottoNumber.valueOf(lottoWinningNumbers.get(5));
    }

    @DisplayName("보너스 당첨 여부 확인")
    @Test
    void purchasedLottoCompareBonusNumber() {
        LottoLottery.updateBonusNumberIndex( resultMatching,0);

        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            LottoLottery.purchasedLottoCompareBonusNumber(lottoWinningNumbers, i);
        }
        assertThat(LottoLottery.bonusCheck).isEqualTo(true);
    }
}