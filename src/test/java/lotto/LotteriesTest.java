package lotto;

import lotto.util.LottoGenerator;
import lotto.util.StatisticCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

public class LotteriesTest {

    private final List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    private List<Lotteries> userLotteriesSet = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<Integer> allMatched = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> fiveMatched = Arrays.asList(2, 3, 4, 5, 6, 7);
        List<Integer> fourMatched = Arrays.asList(3, 4, 5, 6, 7, 8);
        List<Integer> threeMatched = Arrays.asList(4, 5, 6, 7, 8, 9);

        userLotteriesSet.add(new Lotteries(allMatched));
        userLotteriesSet.add(new Lotteries(fiveMatched));
        userLotteriesSet.add(new Lotteries(fourMatched));
        userLotteriesSet.add(new Lotteries(threeMatched));
    }

    @Test
    @DisplayName("사용자가 입력한 금액에 따른 발급할 로또 개수 테스트")
    void lotteryTickerPer1000() {
        assertThat(12345 / 1000).isEqualTo(12);
    }

    @Test
    @DisplayName("오름차순으로 정렬된 6개의 복권 번호를 자동으로 생성함")
    void generateLottoNumber() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lotteries = lottoGenerator.generate();

        assertThat(lotteries).hasSize(6);
    }

    @Test
    @DisplayName("당첨 복권 번호와 자동으로 발급된 로또의 일치 로직")
    void matchWinLottoAndGenerateLotto() {
        Lotteries randomGeneratedLotteries = new Lotteries(Arrays.asList(4, 5, 6, 7, 8, 9));

        int matchCount = LottoMachine.findMatchedLottoNumberCount(winLottoNumber, randomGeneratedLotteries);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("금주의 로또 당첨 번호와 구매한 로또 번호의 통계 구하기")
    void rankOfUsersLotto() {
        List<Rank> ranks = new ArrayList<>();

        for (Lotteries lotteries : userLotteriesSet) {
            int matchCount = LottoMachine.findMatchedLottoNumberCount(winLottoNumber, lotteries);
            Rank lottoRank = Rank.findRank(matchCount, false);
            ranks.add(lottoRank);
        }

        assertThat(ranks).hasSize(4);
        assertThat(frequency(ranks, Rank.FIRST)).isEqualTo(1);
        assertThat(frequency(ranks, Rank.THIRD)).isEqualTo(1);
        assertThat(frequency(ranks, Rank.FOURTH)).isEqualTo(1);
        assertThat(frequency(ranks, Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입한 로또의 금액과 당첨된 로또 번호를 통해 수익률 계산")
    void findTotalRate() {
        int price = 14_000;

        List<Rank> ranks = List.of(Rank.FIFTH);

        double rate = StatisticCalculator.calculateRate(price, ranks);

        assertThat(rate).isEqualTo(0.35);
    }

    @Test
    @DisplayName("구입한 로또 중에서 당첨 번호가 5개가 일치하고 나머지 하나가 보너스 번호와 일치하는 테스트")
    void matchBonusNumber() {
        int matchCount = 5;
        int bonusNumber = 7;
        Lotteries purchaseLotteries = new Lotteries(Arrays.asList(2, 3, 4, 5, 6, 7));

        boolean matchedBonusNumber = purchaseLotteries.isBonusNumberMatched(matchCount, bonusNumber);

        assertThat(matchedBonusNumber).isTrue();
    }

    @Test
    @DisplayName("구입한 로또 중에서 당첨 번호가 5개가 일치하지 않을 경우 다른 번호가 보너스 번호랑 일치해도 false 인 테스트")
    void mismatchBonusNumber() {
        int matchCount = 4;
        int bonusNumber = 6;
        Lotteries purchaseLotteries = new Lotteries(Arrays.asList(1, 2, 3, 4, 5, 6));

        boolean matchedBonusNumber = purchaseLotteries.isBonusNumberMatched(matchCount, bonusNumber);

        assertThat(matchedBonusNumber).isFalse();
    }
}
