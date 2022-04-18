package lotto;

import lotto.util.LottoGenerator;
import lotto.util.StatisticCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    private final List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    private List<Lotto> userLottoSet = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<Integer> allMatched = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> fiveMatched = Arrays.asList(2, 3, 4, 5, 6, 7);
        List<Integer> fourMatched = Arrays.asList(3, 4, 5, 6, 7, 8);
        List<Integer> threeMatched = Arrays.asList(4, 5, 6, 7, 8, 9);

        userLottoSet.add(new Lotto(allMatched));
        userLottoSet.add(new Lotto(fiveMatched));
        userLottoSet.add(new Lotto(fourMatched));
        userLottoSet.add(new Lotto(threeMatched));
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
        Lotto randomGeneratedLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        int matchCount = LottoMachine.findMatchedLottoNumberCount(winLottoNumber, randomGeneratedLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("금주의 로또 당첨 번호와 구매한 로또 번호의 통계 구하기")
    void rankOfUsersLotto() {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : userLottoSet) {
            int matchCount = LottoMachine.findMatchedLottoNumberCount(winLottoNumber, lotto);
            Rank lottoRank = Rank.findRank(matchCount);
            ranks.add(lottoRank);
        }

        assertThat(ranks).hasSize(4);
        assertThat(frequency(ranks, Rank.SIX)).isEqualTo(1);
        assertThat(frequency(ranks, Rank.FIVE)).isEqualTo(1);
        assertThat(frequency(ranks, Rank.FOUR)).isEqualTo(1);
        assertThat(frequency(ranks, Rank.THREE)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입한 로또의 금액과 당첨된 로또 번호를 통해 수익률 계산")
    void findTotalRate() {
        int price = 14_000;

        List<Rank> ranks = List.of(Rank.THREE);

        double rate = StatisticCalculator.calculateRate(price, ranks);

        assertThat(rate).isEqualTo(0.35);
    }
}
