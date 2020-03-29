package lotto;

import lotto.model.LottoNumbers;
import lotto.model.Money;
import lotto.model.MyLottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.MatchingResult.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MyLottosTest {
    private List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
    private LottoNumbers lottoNumbers1;
    private LottoNumbers lottoNumbers2;
    private LottoNumbers lottoNumbers3;
    private LottoNumbers lottoNumbers4;


    @BeforeEach
    void setUp() {
        lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        lottoNumbers3 = new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoNumbers4 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 9));
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 3개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfThreeNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfThreeNumMatching = myLottos.findCountOfNumMatching(winningLotto, THREE);

        //then
        assertThat(countOfThreeNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 4개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfFourNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfFourNumMatching = myLottos.findCountOfNumMatching(winningLotto, FOUR);

        //then
        assertThat(countOfFourNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 5개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfFiveNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfFiveNumMatching = myLottos.findCountOfNumMatching(winningLotto, FIVE);

        //then
        assertThat(countOfFiveNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 6개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfSixNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfSixNumMatching = myLottos.findCountOfNumMatching(winningLotto, SIX);

        //then
        assertThat(countOfSixNumMatching).isEqualTo(1L);
    }

    @DisplayName("당첨번호를 주면, 상금을 알려준다.")
    @Test
    void calculatePrizeMoneyTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Money earningMoney = myLottos.calculateAllPrizeMoney(winningLotto);

        //then
        assertThat(earningMoney).isEqualTo(new Money(2001555000l));
    }

    @DisplayName("당첨번호를 알려주면, 수익률을 알려준다.")
    @Test
    public void calculateEarningRateTest() {
        //given
        LottoNumbers lottoNumbers5 = new LottoNumbers(Arrays.asList(15, 1, 2, 3, 19, 20));
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers5));

        //whenR
        double earningRate = myLottos.calculateEarningRate(winningLotto);

        //then
        assertThat(earningRate).isEqualTo(500);
    }
}