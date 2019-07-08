package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryTest {
    @Test
    @DisplayName("로또를 생성하면, 6개의 숫자로 이루어진 Integer Set 을 반환해야합니다")
    void createLottery_sizeIsEqualToSix() {
        final Lottery actual = Lottery.randomizedInstance();
        assertThat(actual).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또의 숫자는 중복되지 않아야 합니다")
    void createLottery_numbersShouldNotBeDuplicated() {
        final Lottery actual = Lottery.randomizedInstance();
        assertThat(actual).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또의 숫자는 1~45 범위 안에 있어야 합니다")
    void createLottery() {
        final Lottery actual = Lottery.randomizedInstance();
        assertThat(actual)
                .filteredOn(lotteryNumber -> lotteryNumber.compareTo(LotteryNumber.min()) >= 0)
                .filteredOn(lotteryNumber -> lotteryNumber.compareTo(LotteryNumber.max()) <= 0)
                .hasSize(6);
    }

    @Test
    @DisplayName("6개 미만의 숫자를 입력할 경우 IllegalArgumentException 을 발생시킵니다")
    void createWinningLottery() {
        // given
        final Set<LotteryNumber> givenLotteryNumberSet = this.createLotteryNumberSet(1, 2, 3, 4, 5);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.customizedInstance(givenLotteryNumberSet))
                // then
                .withMessageContaining("must be equal to");
    }

    @Test
    @DisplayName("6개 초과의 숫자를 입력할 경우 IllegalArgumentException 을 발생시킵니다")
    void createWinningLottery1() {
        // given
        final Set<LotteryNumber> givenLotteryNumberSet = this.createLotteryNumberSet(1, 2, 3, 4, 5, 6, 7);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.customizedInstance(givenLotteryNumberSet))
                // then
                .withMessageContaining("must be equal to");
    }

    @Test
    @DisplayName("6개의 숫자가 모두 1~45 범위 안에 드는 경우 당첨 로또를 반환합니다")
    void createWinningLottery4() {
        // given
        final Set<LotteryNumber> givenLotteryNumberSet = this.createLotteryNumberSet(1, 2, 3, 4, 5, 6);
        // when
        final Lottery actual = Lottery.customizedInstance(givenLotteryNumberSet);
        // then
        assertThat(actual).contains(
                LotteryNumber.from(1),
                LotteryNumber.from(2),
                LotteryNumber.from(3),
                LotteryNumber.from(4),
                LotteryNumber.from(5),
                LotteryNumber.from(6)
        );
    }

    private Set<LotteryNumber> createLotteryNumberSet(Integer... numbers) {
        final List<Integer> numberList = Arrays.asList(numbers);
        return numberList.stream()
                .map(LotteryNumber::from)
                .collect(Collectors.toSet());
    }
}