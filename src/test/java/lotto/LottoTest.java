package lotto;

import lotto.util.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    private final List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    private LottoMachine lottoMachine;
    private List<List<Integer>> userLottoSet = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();

        List<Integer> allMatched = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> fiveMatched = Arrays.asList(2, 3, 4, 5, 6, 7);
        List<Integer> fourMatched = Arrays.asList(3, 4, 5, 6, 7, 8);
        List<Integer> threeMatched = Arrays.asList(4, 5, 6, 7, 8, 9);

        userLottoSet.add(allMatched);
        userLottoSet.add(fiveMatched);
        userLottoSet.add(fourMatched);
        userLottoSet.add(threeMatched);
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
        List<Integer> randomGeneratedLotto = Arrays.asList(4, 5, 6, 7, 8, 9);

        int matchCount = lottoMachine.matchLottoNumber(winLottoNumber, randomGeneratedLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("금주의 로또 당첨 번호와 구매한 로또 번호의 통계 구하기")
    void statisticsOfUsersLotto() {
        List<Statistic> statistics = new ArrayList<>();

        for (List<Integer> lotto : userLottoSet) {
            int matchCount = lottoMachine.matchLottoNumber(winLottoNumber, lotto);
            Statistic lottoRank = Statistic.findRank(matchCount);
            statistics.add(lottoRank);
        }

        assertThat(statistics).hasSize(4);
        assertThat(frequency(statistics, Statistic.SIX)).isEqualTo(1);
        assertThat(frequency(statistics, Statistic.FIVE)).isEqualTo(1);
        assertThat(frequency(statistics, Statistic.FOUR)).isEqualTo(1);
        assertThat(frequency(statistics, Statistic.THREE)).isEqualTo(1);
    }
}
