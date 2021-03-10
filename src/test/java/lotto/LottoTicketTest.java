package lotto;

import lotto.domain.LotteryNumber;
import lotto.domain.LotteryTicket;
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

public class LottoTicketTest {

    private static final String TEST_DELIMITER = ",";

    @Test
    @DisplayName("자동생성시 중복되는 로또번호가 있는지 갯수는 6개가 맞는지 테스트")
    void create_auto() {
        int price = 1000;
        LotteryTicket lotteryTicket = LotteryTicket.auto(price);
        List<Integer> lottoNumberList = lotteryTicket.getLottoNumberList();
        HashSet<Integer> duplicateRemovedNumberList = new HashSet<>(lottoNumberList);

        assertThat(duplicateRemovedNumberList.size()).isEqualTo(6);
        assertThat(lotteryTicket.getPrice()).isEqualTo(price);
    }

    @Test
    @DisplayName("수동생성 테스트")
    void create_with_selected_numbers() {
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryTicket lotteryTicket = new LotteryTicket(numberList, price);

        assertThat(lotteryTicket.getPrice()).isEqualTo(price);
        assertThat(lotteryTicket.getLottoNumberList()).isEqualTo(numberList);
    }

    @Test
    @DisplayName("수동생성시 중복되는 번호가 있으면 예외 발생 테스트")
    void create_with_duplicate_selected_numbers() {
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LotteryTicket(numberList, price)
        );
    }


    @Test
    @DisplayName("수동생성시 번호가 6개가 안되면 예외 발생 테스트")
    void create_with_less_than_6_numbers() {
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LotteryTicket(numberList, price)
        );
    }

    @Test
    @DisplayName("생성된 로또 번호로 isMatch로 포함된 숫자가 있느지 테스트")
    void isMatch() {
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        int matchNumber = 1;
        int notMatchNumber = 7;

        LotteryTicket lotteryTicket = new LotteryTicket(numberList, price);

        assertThat(lotteryTicket.isMatch(LotteryNumber.valueOf(matchNumber))).isTrue();
        assertThat(lotteryTicket.isMatch(LotteryNumber.valueOf(notMatchNumber))).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6,7,8,9,10,11:1", "12,23,45,33,20,19:33,20,21,23,45,19:5", "1,2,3,4,5,6:13,7,8,9,10,12:0"}, delimiter = ':')
    @DisplayName("생성된 로또 번호로 findMatchCount로 다른 로또번호와 대조해 몇개가 match되는지 테스트")
    void findMatchCount(String lotteryTicketNumbers, String toMatchLotteryTicketNumbers, int matchCount) {
        int price = 1000;
        String[] lotteryTicketNumbersArray = lotteryTicketNumbers.split(TEST_DELIMITER);
        String[] toMatchLotteryTicketNumbersArray = toMatchLotteryTicketNumbers.split(TEST_DELIMITER);


        List<Integer> numberList = Arrays.stream(lotteryTicketNumbersArray).map(Integer::parseInt).collect(Collectors.toList());
        LotteryTicket lotteryTicket = new LotteryTicket(numberList, price);

        List<Integer> numberListToMatch = Arrays.stream(toMatchLotteryTicketNumbersArray).map(Integer::parseInt).collect(Collectors.toList());
        LotteryTicket toMatchLotteryTicket = new LotteryTicket(numberListToMatch, price);


        assertThat(lotteryTicket.findMatchCount(toMatchLotteryTicket)).isEqualTo(matchCount);

    }

}
