package lotto.model.ticket;

import lotto.model.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryTicketTest {

    LotteryTicket lotteryTicket;

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4","1,2,3,4,5,6,7"})
    @DisplayName(", 기준으로 분리했을 때 리스트 사이즈가 6이 아니면 에외발생")
    void inputListSizeIsNotSixThrowsException(String input){
        List<Lotto> list = splitToLottoList(input);
        throwExceptionCheck(list, "6개 번호가 선택되어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,2,3,4,5","1,2,3,4,5,5"})
    @DisplayName("로또 번호에 chooseNumber중복이 있으면 에외발생")
    void duplicateNumberExistExceptionTest(String input){
        List<Lotto> list = splitToLottoList(input);
        throwExceptionCheck(list, "중복된 번호가 있습니다.");
    }

    private void throwExceptionCheck(List<Lotto> list, String s) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryTicket = new LotteryTicket(list))
                .withMessage(s);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6","1,5,6,25,36,42"})
    @DisplayName("로또 정상 번호고 중복이 없을 경우 정상동작 테스트")
    void validNumberTest(String input){
        List<Lotto> list = splitToLottoList(input);
        lotteryTicket = new LotteryTicket(list);
        assertThat(lotteryTicket.getNumbers()).isEqualTo(list);
    }

    private List<Lotto> splitToLottoList(String input) {
        return Arrays.stream(input.split(","))
                .map((value) -> new Lotto(Integer.parseInt(value)))
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6|2,5,6,7,8,9|3","1,2,3,4,5,6|3,4,5,6,7,8|4", "1,2,3,4,5,6|7,8,9,10,11,12|0"}, delimiter = '|')
    @DisplayName("두 복권 겹치는 숫자 개수 구하는 것 테스트")
    void getMatchCountTest(String input1, String input2, int matchCount){
        LotteryTicket ticket1 = new LotteryTicket(splitToLottoList(input1));
        LotteryTicket ticket2 = new LotteryTicket(splitToLottoList(input2));
        assertThat(ticket1.getMatchCount(ticket2)).isEqualTo(matchCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6|3|true","1,2,3,4,5,6|3|true","1,2,3,4,5,6|7|false","1,2,3,4,5,6|10|false"}, delimiter = '|')
    @DisplayName("해당 번호가 복권에 있는지 확인하는 로직 테스트")
    void matchTest(String input, int number, boolean match){
        lotteryTicket = new LotteryTicket(splitToLottoList(input));
        assertThat(lotteryTicket.match(new Lotto(number))).isEqualTo(match);
    }
}