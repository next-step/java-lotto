package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryTest {
    @Test
    @DisplayName("로또를 생성하면, 6개의 숫자로 이루어진 Integer Set 을 반환해야합니다")
    void createLottery_sizeIsEqualToSix() {
        final Lottery actual = Lottery.randomizedInstance();

        final Set<Integer> numberSet = this.getNumberSet(actual);
        assertThat(numberSet).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또의 숫자는 중복되지 않아야 합니다")
    void createLottery_numbersShouldNotBeDuplicated() {
        final Lottery actual = Lottery.randomizedInstance();

        final Set<Integer> numberSet = this.getNumberSet(actual);
        assertThat(numberSet).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또의 숫자는 1~45 범위 안에 있어야 합니다")
    void createLottery() {
        final Lottery actual = Lottery.randomizedInstance();

        final Set<Integer> numberSet = this.getNumberSet(actual);
        assertThat(numberSet)
                .filteredOn(value -> value >= 1 && value <= 45)
                .hasSize(6);
    }

    @Test
    @DisplayName("6개 미만의 숫자를 입력할 경우 IllegalArgumentException 을 발생시킵니다")
    void createWinningLottery() {
        // given
        final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        final Set<Integer> givenNumberSet = new HashSet<>(numberList);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.customizedInstance(givenNumberSet))
                // then
                .withMessageContaining("must be equal to");
    }

    @Test
    @DisplayName("6개 초과의 숫자를 입력할 경우 IllegalArgumentException 을 발생시킵니다")
    void createWinningLottery1() {
        // given
        final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        final Set<Integer> givenNumberSet = new HashSet<>(numberList);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.customizedInstance(givenNumberSet))
                // then
                .withMessageContaining("must be equal to");
    }

    @Test
    @DisplayName("6개의 숫자를 입력했지만 1보다 작은 숫자가 존재하는 경우 IllegalArgumentException 을 발생시킵니다")
    void createWinningLottery2() {
        // given
        final List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5);
        final Set<Integer> givenNumberSet = new HashSet<>(numberList);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.customizedInstance(givenNumberSet))
                // then
                .withMessageContaining("between 1 and 45");
    }

    @Test
    @DisplayName("6개의 숫자를 입력했지만 45보다 큰 숫자가 존재하는 경우 IllegalArgumentException 을 발생시킵니다")
    void createWinningLottery3() {
        // given
        final List<Integer> numberList = Arrays.asList(46, 1, 2, 3, 4, 5);
        final Set<Integer> givenNumberSet = new HashSet<>(numberList);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.customizedInstance(givenNumberSet))
                // then
                .withMessageContaining("between 1 and 45");
    }

    @Test
    @DisplayName("6개의 숫자가 모두 1~45 범위 안에 드는 경우 당첨 로또를 반환합니다")
    void createWinningLottery4() {
        // given
        final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Set<Integer> givenNumberSet = new HashSet<>(numberList);
        // when
        final Lottery actual = Lottery.customizedInstance(givenNumberSet);
        // then
        final Set<Integer> numberSet = this.getNumberSet(actual);
        assertThat(numberSet).containsExactly(1, 2, 3, 4, 5, 6);
    }

    private Set<Integer> getNumberSet(Lottery lottery) {
        try {
            return (Set<Integer>) ReflectionUtils.tryToReadFieldValue(Lottery.class, "numberSet", lottery).get();
        } catch (Exception ignored) {
            throw new AssertionError();
        }
    }
}