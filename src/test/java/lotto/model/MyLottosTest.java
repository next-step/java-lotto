package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MyLottosTest {
    private final WinningLottoNumbers WINNING_LOTTO = new WinningLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    private final int BONUS_BALL = 9;

    private LottoNumbers lottoNumbers1;
    private LottoNumbers lottoNumbers2;
    private LottoNumbers lottoNumbers3;
    private LottoNumbers lottoNumbers4;
    private LottoNumbers lottoNumbers5;


    @BeforeEach
    void setUp() {
        lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        lottoNumbers3 = new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, BONUS_BALL));
        lottoNumbers4 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, BONUS_BALL));
        lottoNumbers5 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 22));
    }

    @DisplayName("구매한 로또 중에 5등 갯수를 리턴한다.")
    @Test
    void findCountOfThreeNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfThreeNumMatching = myLottos.findCountOfNumMatching(WINNING_LOTTO, FIFTH, BONUS_BALL);

        //then
        assertThat(countOfThreeNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 4등의 갯수를 리턴한다.")
    @Test
    void findCountOfFourNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfFourNumMatching = myLottos.findCountOfNumMatching(WINNING_LOTTO, FOURTH, BONUS_BALL);

        //then
        assertThat(countOfFourNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 2등(5개 + 보너스번호) 갯수를 리턴한다.")
    @Test
    void findCountOfSecondTest() {
        //given
        MyLottos myLottos
                = new MyLottos(Arrays.asList(lottoNumbers4, lottoNumbers5));

        //when
        Long countOfFiveNumMatching = myLottos.findCountOfNumMatching(WINNING_LOTTO, SECOND, BONUS_BALL);

        //then
        assertThat(countOfFiveNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 1등의 갯수를 리턴한다.")
    @Test
    void findCountOfSixNumMatchingTest() {
        //given
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        //when
        Long countOfSixNumMatching = myLottos.findCountOfNumMatching(WINNING_LOTTO, FIRST, BONUS_BALL);

        //then
        assertThat(countOfSixNumMatching).isEqualTo(1L);
    }

    @DisplayName("당첨번호를 주면, 상금을 알려준다.")
    @Test
    void calculatePrizeMoneyTest() {
        //given
        MyLottos myLottos
                = new MyLottos(Arrays.asList(lottoNumbers3, lottoNumbers4, lottoNumbers5));

        //when
        Money earningMoney = myLottos.calculateAllPrizeMoney(WINNING_LOTTO, BONUS_BALL);

        //then
        assertThat(earningMoney).isEqualTo(new Money(31_505_000l));
    }

    @DisplayName("당첨번호를 알려주면, 수익률을 알려준다.")
    @Test
    public void calculateEarningRateTest() {
        //given
        LottoNumbers lottoNumbers5 = new LottoNumbers(Arrays.asList(15, 1, 2, 3, 19, 20));
        MyLottos myLottos = new MyLottos(Arrays.asList(lottoNumbers5));

        //whenR
        double earningRate = myLottos.calculateEarningRate(WINNING_LOTTO, BONUS_BALL);

        //then
        assertThat(earningRate).isEqualTo(500);
    }
}