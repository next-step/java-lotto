package lottery.domain;

import static java.util.Arrays.asList;
import static lottery.domain.constant.LotteryNumberRule.LOTTERY_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lottery.domain.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryTest {

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR =
            new RandomNumberGenerator();

    private static final Set<LotteryNumber> LOTTERY_NUMBERS =
            new HashSet<>(Arrays.asList(new LotteryNumber(1),
                    new LotteryNumber(2),
                    new LotteryNumber(3),
                    new LotteryNumber(4),
                    new LotteryNumber(5),
                    new LotteryNumber(6)));

    private static final Set<LotteryNumber> NOT_COMPLETED_NUMBERS =
            new HashSet<>(List.of(new LotteryNumber(1)));

    @Test
    @DisplayName("동일한 번호를 가진 LotteryNumber 2개 가 들어갈 경우 동일 객체로 판단 1개의 객체만 등록한다")
    void setLotteryNumberTest() {
        Set<LotteryNumber> lotteryNumbers = new HashSet<>(asList(
                new LotteryNumber(1),
                new LotteryNumber(1)));

        assertThat(lotteryNumbers).hasSize(1);
    }

    @Test
    @DisplayName("Set Collection 객체의 크기가 6이 된 후 그 값을 반환한다.")
    void returnFullLotteryNumbers() {
        Set<LotteryNumber> lotteryNumbers = new HashSet<>();
        while (lotteryNumbers.size() != LOTTERY_NUMBERS_SIZE.getRuleNumber()) {
            lotteryNumbers.add(new LotteryNumber(RANDOM_NUMBER_GENERATOR.generatedNumber()));
        }
        assertThat(lotteryNumbers).hasSize(LOTTERY_NUMBERS_SIZE.getRuleNumber());
    }

    @Test
    @DisplayName("로또 당첨 예상번 크기가 6인 경우 정상 객체가 생성된다")
    void objCreateSuccessTest() {
        assertDoesNotThrow(() -> new Lottery(LOTTERY_NUMBERS));
    }

    @Test
    @DisplayName("로또 당첨 예상번호 크기가 6이 아닐 경우 익셉션을 발생시킨다.")
    void objCreateErrorTest() {
        assertThatThrownBy(() -> new Lottery(NOT_COMPLETED_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 총 6개의 숫자로 구성되어야합니다.");
    }

    @Test
    @DisplayName("기본생성자 객체 생성시 자동으로 6개의 로또 번호를 생성한다.")
    void autoGenerateTest() {
        assertThat(new Lottery().size()).isEqualTo(LOTTERY_NUMBERS_SIZE.getRuleNumber());
    }

    @Test
    @DisplayName("자동 발생한 숫자가 매주 당첨 번호와 최종 몇개가 일치하는지의 값을 반환한다.")
    void intersectionSizeTest() {
        Lottery lotterySixNumbers = new Lottery("1,2,3,7,8,9");
        assertThat(new Lottery(LOTTERY_NUMBERS).intersectionSize(lotterySixNumbers.getNumbers()))
                .isEqualTo(3);
    }
}
