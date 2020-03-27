package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
    private Lotto lotto1;
    private Lotto lotto2;
    private Lotto lotto3;
    private Lotto lotto4;


    @BeforeEach
    void setUp() {
        lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        lotto3 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 3개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfThreeNumMatchingTest() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        //when
        Long countOfThreeNumMatching = lottos.findCountOfThreeNumMatching(winningLotto);

        //then
        assertThat(countOfThreeNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 4개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfFourNumMatchingTest() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        //when
        Long countOfFourNumMatching = lottos.findCountOfFourNumMatching(winningLotto);

        //then
        assertThat(countOfFourNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 5개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfFiveNumMatchingTest() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        //when
        Long countOfFiveNumMatching = lottos.findCountOfFiveNumMatching(winningLotto);

        //then
        assertThat(countOfFiveNumMatching).isEqualTo(1L);
    }

    @DisplayName("구매한 로또 중에 당첨번호와 번호 6개가 일치하는 로또의 갯수를 리턴한다.")
    @Test
    void findCountOfSixNumMatchingTest() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        //when
        Long countOfSixNumMatching = lottos.findCountOfSixNumMatching(winningLotto);

        //then
        assertThat(countOfSixNumMatching).isEqualTo(1L);
    }

    @DisplayName("당첨번호를 주면, 상금을 알려준다.")
    @Test
    void calculatePrizeMoneyTest() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        //when
        Money earningMoney = lottos.calculatePrizeMoney(winningLotto);

        //then
        assertThat(earningMoney).isEqualTo(new Money(201555000l));
    }
}