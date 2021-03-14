package lotto;

import lotto.domain.Lottery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryTest {
    private static final String TEST_DELIMITER = ",";

    @Test
    @DisplayName("자동생성시 중복되는 로또번호가 있는지 갯수는 6개가 맞는지 테스트")
    void create_auto() {
        Lottery lottery = Lottery.auto();
        List<Integer> lottoNumberValueList = lottery.getNumberValueList();
        HashSet<Integer> duplicateRemovedNumberList = new HashSet<>(lottoNumberValueList);

        assertThat(duplicateRemovedNumberList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동생성 테스트")
    void create_with_selected_numbers() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottery lottery = new Lottery(numberList);

        assertThat(lottery.getNumberValueList()).isEqualTo(numberList);
    }

    @Test
    @DisplayName("수동생성시 중복되는 번호가 있으면 예외 발생 테스트")
    void create_with_duplicate_selected_numbers() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Lottery(numberList)
        );
    }

    @Test
    @DisplayName("수동생성시 번호가 6개가 안되면 예외 발생 테스트")
    void create_with_less_than_6_numbers() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Lottery(numberList)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6,7,8,9,10,11:1", "12,23,45,33,20,19:33,20,21,23,45,19:5", "1,2,3,4,5,6:13,7,8,9,10,12:0"}, delimiter = ':')
    @DisplayName("생성된 로또 번호로 findMatchCount로 다른 로또번호와 대조해 몇개가 match되는지 테스트")
    void findMatchCount(String lotteryNumbers, String toMatchLotteryNumbers, int matchCount) {
        String[] lotteryNumbersArray = lotteryNumbers.split(TEST_DELIMITER);
        String[] toMatchLotteryNumbersArray = toMatchLotteryNumbers.split(TEST_DELIMITER);


        List<Integer> numberList = Arrays.stream(lotteryNumbersArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lottery lottery = new Lottery(numberList);

        List<Integer> numberListToMatch = Arrays.stream(toMatchLotteryNumbersArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lottery toMatchLotteryTicket = new Lottery(numberListToMatch);

        assertThat(lottery.getMatchCount(toMatchLotteryTicket)).isEqualTo(matchCount);
    }
}
