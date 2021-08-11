package lottery.domain;

import lottery.domain.winningstrategy.MatchWinningLotteryStrategy;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LotteryTest {

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInput() {
        // given
        List<LotteryNumber> lotteryNumbers = null;
        String message = "입력값은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Lottery(lotteryNumbers);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
    
    @Test
    @DisplayName("6개 초과 로또 숫자 입력")
    public void overLotteryNumbers() {
        // given
        int lotteryNumberSize = 7;
        List<LotteryNumber> lotteryNumbers = getLotteryNumbers(1, lotteryNumberSize);
        String message = "로또 숫자는 6개여야 합니다 -> " + lotteryNumberSize;

        // when
        ThrowingCallable throwingCallable = () -> new Lottery(lotteryNumbers);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("6개 미만의 로또 숫자 입력")
    public void lessLotteryNumbers() {
        // given
        int lotteryNumberSize = 5;
        List<LotteryNumber> lotteryNumbers = getLotteryNumbers(1, lotteryNumberSize);
        String message = "로또 숫자는 6개여야 합니다 -> " + lotteryNumberSize;

        // when
        ThrowingCallable throwingCallable = () -> new Lottery(lotteryNumbers);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("중복된 로또 숫자 입력")
    public void duplicatedLotteryNumbers() {
        // given
        List<LotteryNumber> lotteryNumbers = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        String message = "로또에서 중복된 숫자는 존재 할 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Lottery(lotteryNumbers);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getLotteryResult 테스트")
    public void getLotteryResult() {
        // given
        Lottery lottery = new Lottery(getLotteryNumbers(1, 6));
        Lottery winningLottery = new Lottery(getLotteryNumbers(2, 7));
        LotteryResult expectedLotteryResult = LotteryResult.FIVE_MATCHES;

        // when
        LotteryResult lotteryResult = lottery.getLotteryResult(new MatchWinningLotteryStrategy(winningLottery));

        // then
        assertThat(lotteryResult).isEqualTo(expectedLotteryResult);
    }

    @Test
    @DisplayName("getMatchesScore 테스트")
    public void getMatchesScore() {
        // given
        Lottery lottery = new Lottery(getLotteryNumbers(1, 6));
        Lottery winningLottery = new Lottery(getLotteryNumbers(2, 7));
        int expectedMatchesCount = 5;

        // when
        int matchesCount = lottery.getMatchesCount(winningLottery);

        // then
        assertThat(matchesCount).isEqualTo(expectedMatchesCount);
    }

    @Test
    @DisplayName("getBonusMatchesScore 테스트")
    public void getBonusMatchesScore() {
        // given
        Lottery lottery = new Lottery(getLotteryNumbers(1, 6));
        LotteryNumber bonusNumber = new LotteryNumber(5);
        boolean expectedMatch = true;

        // when
        boolean matchesCount = lottery.getBonusMatchesScore(bonusNumber);

        // then
        assertThat(matchesCount).isEqualTo(expectedMatch);
    }

    private List<LotteryNumber> getLotteryNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }
}
