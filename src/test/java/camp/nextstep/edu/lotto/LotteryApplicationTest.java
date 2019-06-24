package camp.nextstep.edu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryApplicationTest {

    private LotteryApplication lotteryApplication;

    @BeforeEach
    void setup() {
        lotteryApplication = new LotteryApplication();
    }

    @Test
    @DisplayName("1000원 이상을 입력할 경우 입력한 값을 1000원으로 나눈 몫을 반환합니다")
    void calculateNumberOfAvailableLottery() {
        // given
        final NaturalNumber investment = NaturalNumber.from(14000);
        // when
        final NaturalNumber numberOfLotteries = lotteryApplication.calculateNumberOfAvailableLotteries(investment);
        // then
        assertThat(numberOfLotteries).isEqualTo(NaturalNumber.from(14));
    }

    @Test
    @DisplayName("0을 입력할 경우 0개의 로또를 반환합니다")
    void purchase_zero() {
        // given
        final NaturalNumber naturalNumber = NaturalNumber.from(0);
        // when
        final List<Lottery> lottery = lotteryApplication.purchase(naturalNumber);
        // then
        assertThat(lottery).hasSize(0);
    }

    @Test
    @DisplayName("양수를 입력할 경우 해당 숫자만큼의 로또를 반환합니다")
    void purchase() {
        // given
        final NaturalNumber naturalNumber = NaturalNumber.from(14);
        // when
        final List<Lottery> lottery = lotteryApplication.purchase(naturalNumber);
        // then
        assertThat(lottery).hasSize(14);
    }

    @Test
    @DisplayName("당첨 로또가 null 이면 IllegalArgumentException 을 발생시킵니다")
    void score1() {
        // given
        final Lottery lottery = Lottery.randomizedInstance();
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.countScore(lottery, null))
                // then
                .withMessageContaining("must not be null");
    }

    @Test
    @DisplayName("구입한 로또가 null 이면 IllegalArgumentException 을 발생시킵니다")
    void score2() {
        // given
        final Lottery lottery = Lottery.randomizedInstance();
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.countScore(null, lottery))
                // then
                .withMessageContaining("must not be null");
    }


    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 0개")
    void score3() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(21, 22, 23, 24, 25, 26));
        final int expected = 0;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 1개")
    void score4() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(1, 12, 13, 14, 15, 16));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 22, 23, 24, 25, 26));
        final int expected = 1;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 2개")
    void score5() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(1, 2, 13, 14, 15, 16));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 23, 24, 25, 26));
        final int expected = 2;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 3개")
    void score6() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 14, 15, 16));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 24, 25, 26));
        final int expected = 3;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 4개")
    void score7() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 25, 26));
        final int expected = 4;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 5개")
    void score8() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 16));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 26));
        final int expected = 5;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    @Test
    @DisplayName("구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다 : 0개")
    void score9() {
        final Set<Integer> givenNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        final int expected = 6;
        this.testCountScore(givenNumberSet, winningNumberSet, expected);
    }

    private void testCountScore(Set<Integer> givenNumberSet, Set<Integer> winningNumberSet, int expected) {
        // given
        final Lottery lottery = Lottery.customizedInstance(givenNumberSet);
        final Lottery winningLottery = Lottery.customizedInstance(winningNumberSet);
        // when
        final int actual = lotteryApplication.countScore(lottery, winningLottery);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력한 점수가 0보다 작으면 IllegalArgumentException 을 발생시킵니다")
    void prize() {
        // given
        final int score = -1;
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.getPrize(score))
                // then
                .withMessageContaining("must be greater than or equal to");
    }
}