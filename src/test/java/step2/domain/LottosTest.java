package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 당첨 번호를 전달하면 일치하는 개수가 몇 개 있는지 알 수 있다.")
    @Test
    void getWinningInfo()  {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        Lotto lotto1 = Lotto.from(30, 20, 25, 1, 2, 3); //3개일치
        Lotto lotto2 = Lotto.from(30, 20, 25, 1, 2, 3); //3개일치
        Lotto lotto3 = Lotto.from(1, 2, 3, 4, 5, 43); //5개 일치
        List<Lotto> lottoList = createLottoListFrom(lotto1, lotto2, lotto3);

        Lottos lottos = new Lottos(lottoWinningRules, lottoList, 2000);

        //when
        Map<Integer, Integer> countNumberOfMatching = lottos.countNumberOfMatching(lottoWinningNumbers);


        //then
        assertThat(countNumberOfMatching.get(3)).isEqualTo(2);
        assertThat(countNumberOfMatching.get(5)).isEqualTo(1);
        assertThat(countNumberOfMatching.keySet().size()).isEqualTo(2);
    }

    @DisplayName("로또 당첨금을 계산한다.")
    @Test
    void getPrizeMoney() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        Lotto lotto1 = Lotto.from(30, 20, 25, 1, 2, 3); //3개일치
        Lotto lotto2 = Lotto.from(1, 2, 3, 4, 5, 43); //5개 일치
        List<Lotto> lottoList = createLottoListFrom(lotto1, lotto2);

        Lottos lottos = new Lottos(lottoWinningRules, lottoList, 2000);

        //when
        int prizeMoney = lottos.prizeMoney(lottoWinningNumbers);

        //then
        assertThat(prizeMoney).isEqualTo(1505000);
    }

    @DisplayName("로또 당첨 번호를 인자로 전달받아 수익률을 계산한다.")
    @Test
    void earningRateFromLottoWinningNumbers() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        Lotto lotto1 = Lotto.from(30, 20, 25, 1, 2, 3); //3개일치
        Lotto lotto2 = Lotto.from(1, 2, 3, 33, 22, 43); //3개 일치
        List<Lotto> lottoList = createLottoListFrom(lotto1, lotto2);

        Lottos lottos = new Lottos(lottoWinningRules, lottoList, 2000);

        //when
        double earningRate = lottos.earningRate(lottoWinningNumbers);

        //then
        assertThat(earningRate).isEqualTo(5);
    }

    @DisplayName("로또 당첨 번호를 인자로 전달받아 수익률을 계산한다.")
    @Test
    void earningRateFromCountOfMatching() {
        //given
        Map<Integer, Integer> countOfMatchingMap = new HashMap<>();
        countOfMatchingMap.put(3, 2);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        Lotto lotto1 = Lotto.from(30, 20, 25, 1, 2, 3); //3개일치
        Lotto lotto2 = Lotto.from(1, 2, 3, 33, 22, 43); //3개 일치
        List<Lotto> lottoList = createLottoListFrom(lotto1, lotto2);

        Lottos lottos = new Lottos(lottoWinningRules, lottoList, 2000);

        //when
        double earningRate = lottos.earningRate(countOfMatchingMap);

        //then
        assertThat(earningRate).isEqualTo(5);
    }


    private List<Lotto> createLottoListFrom(Lotto... lottos) {
        List<Lotto> lottoList = new ArrayList<>();
        Collections.addAll(lottoList, lottos);
        return lottoList;
    }
}