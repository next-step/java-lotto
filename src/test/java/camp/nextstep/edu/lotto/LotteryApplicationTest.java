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
                .isThrownBy(() -> lotteryApplication.getReward(score))
                // then
                .withMessageContaining("must be greater than or equal to");
    }

    @Test
    @DisplayName("한 개도 일치하지 않는 경우 0원을 반환합니다")
    void prize1() {
        this.testGetReward(0, 0);
    }

    @Test
    @DisplayName("한 개 일치하는 경우 0 원 을 반환합니다")
    void prize2() {
        this.testGetReward(1, 0);
    }

    @Test
    @DisplayName("두 개 일치하는 경우 0 원 을 반환합니다")
    void prize3() {
        this.testGetReward(2, 0);
    }

    @Test
    @DisplayName("세 개 일치하는 경우 5000 원 을 반환합니다")
    void prize4() {
        this.testGetReward(3, 5000);
    }

    @Test
    @DisplayName("네 개 일치하는 경우 50000 원 을 반환합니다")
    void prize5() {
        this.testGetReward(4, 50000);
    }

    @Test
    @DisplayName("다섯 개 일치하는 경우 1500000 원 을 반환합니다")
    void prize6() {
        this.testGetReward(5, 1500000);
    }

    @Test
    @DisplayName("여섯 개 일치하는 경우 2000000000 원 을 반환합니다")
    void prize7() {
        this.testGetReward(6, 2000000000);
    }

    private void testGetReward(int score, int expected) {
        // given
        final int givenScore = score;
        // when
        final long actual = lotteryApplication.getReward(givenScore);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}