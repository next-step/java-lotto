package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteryAwardSystemTest {

    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private static Lottos testLottos;
    private static final LottoNumbers winnerNumbers = LottoNumbers.fromIntegerList(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final Integer FIRST_WINNER_PRIZE = 2000000000;
    private static final Integer SECOND_WINNER_PRIZE = 30000000;
    private static final Integer THIRD_WINNER_PRIZE = 1500000;
    private static final Integer FOURTH_WINNER_PRIZE = 50000;
    private static final Integer FIFTH_WINNER_PRIZE = 5000;

    @BeforeAll
    static void beforeAll() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            LottoNumbers numbers = LottoNumbers.fromIntegerList(Arrays.asList(1 + i, 2 + i, 3 + i, 4 + i, 5 + i, 6 + i));
            lottos.add(new Lotto(numbers, randomNumberGenerator));
        }
        testLottos = new Lottos(lottos);
    }

    @Test
    public void 일등부터_사등까지_정보를_반환한다() {
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(winnerNumbers, bonusNumber);
        LotteryAwardSystem lottoSystem = new LotteryAwardSystem(testLottos, winningNumbers, 4000);
        Map<PrizeLevel, Integer> winnersCountMap = lottoSystem.getWinnersCountMap();

        assertAll(
                () -> assertThat(winnersCountMap.get(PrizeLevel.FIRST)).isEqualTo(1),
                () -> assertThat(winnersCountMap.get(PrizeLevel.SECOND)).isEqualTo(1),
                () -> assertThat(winnersCountMap.get(PrizeLevel.FOURTH)).isEqualTo(1),
                () -> assertThat(winnersCountMap.get(PrizeLevel.FIFTH)).isEqualTo(1)
        );
    }

    @Test
    public void 수익률을_알려준다() {
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(winnerNumbers, bonusNumber);
        LotteryAwardSystem lottoSystem = new LotteryAwardSystem(testLottos, winningNumbers, 4000);

        assertThat(lottoSystem.getProfitRate()).isEqualTo(507513.75);
    }

    @Test
    public void 당첨_수익금을_알려준다() {
        assertAll(
                () -> assertThat(PrizeLevel.FIRST.getPrizeAmount()).isEqualTo(FIRST_WINNER_PRIZE),
                () -> assertThat(PrizeLevel.THIRD.getPrizeAmount()).isEqualTo(THIRD_WINNER_PRIZE),
                () -> assertThat(PrizeLevel.FOURTH.getPrizeAmount()).isEqualTo(FOURTH_WINNER_PRIZE),
                () -> assertThat(PrizeLevel.FIFTH.getPrizeAmount()).isEqualTo(FIFTH_WINNER_PRIZE)
        );
    }

    @Test
    public void 보너스_볼과_5개의_숫자가_일치하면_3억의_상금을_받는다() {
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(winnerNumbers, bonusNumber);
        LotteryAwardSystem lottoSystem = new LotteryAwardSystem(testLottos, winningNumbers, 4000);
        assertThat(lottoSystem.getWinnersCountMap().get(PrizeLevel.SECOND)).isEqualTo(1);
    }
}
