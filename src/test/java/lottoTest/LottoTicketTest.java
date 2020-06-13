package lottoTest;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.IntegerUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket ticket = new LottoTicket();

    @DisplayName("로또 번호를 자동으로 생성한다 - 중복 없는지 체크")
    @Test
    public void isItDuplication() {
        List<Integer> lotto1 = ticket.buyTicket();
        List<Integer> lotto2 = ticket.buyTicket();

        assertThat(lotto1.size()).isEqualTo(6);
        assertThat(lotto2.size()).isEqualTo(6);
        assertThat(lotto1).isNotEqualTo(lotto2);
    }

    @DisplayName("당첨번호를 입력 받으면 당첨된 번호의 갯수 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "11,12,13,14,15,16 : 0",
            "1,12,13,14,15,16 : 1",
            "1,2,13,14,15,16 : 2",
            "1,2,3,14,15,16 : 3",
            "1,2,3,4,15,16 : 4",
            "1,2,3,4,5,16 : 5",
            "1,2,3,4,5,6 : 6"}, delimiter = ':')
    public void getPrize(String nums, int expected) {
        String[] splitNumbers = nums.split(",");
        int[] numbers = new int[splitNumbers.length];
        for (int i = 0; i < splitNumbers.length; i++) {
            numbers[i] = IntegerUtils.parsing(splitNumbers[i]);
        }

        LottoTicket ticketWithNumbers = new LottoTicket(numbers);

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < Lotto.LIMIT; i++) {
            winningNumbers.add(i + 1);
        }

        assertThat(ticketWithNumbers.isWinner(winningNumbers)).isEqualTo(expected);
    }

}
