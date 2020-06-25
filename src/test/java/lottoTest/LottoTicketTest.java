package lottoTest;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntegerUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket ticket = new LottoTicket();

    @DisplayName("로또 번호를 자동으로 생성한다 - 중복 없는지 체크")
    @Test
    public void isItDuplication() {
        LottoNumbers lotto1 = ticket.getMyNumbers();
        LottoNumbers lotto2 = ticket.getMyNumbers();

        assertThat(lotto1.getLength()).isEqualTo(6);
        assertThat(lotto2.getLength()).isEqualTo(6);
    }

    @DisplayName("당첨번호를 입력 받으면 당첨된 번호의 갯수 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "11,12,13,14,15,16 : 16 : 6",
            "1,12,13,14,15,16 : 16 : 6",
            "1,2,13,14,15,16 : 16 : 6",
            "1,2,3,14,15,16 : 16 : 5",
            "1,2,3,4,15,16 : 16 : 4",
            "1,2,3,4,5,17 : 16 : 3",
            "1,2,3,4,5,16 : 16 : 2",
            "1,2,3,4,5,6 : 16 : 1"}, delimiter = ':')
    public void getPrize(String myNumbers, int bonus, int expected) {
        LottoNumber[] winningNumbers = new LottoNumber[Lotto.LIMIT];
        for (int i = 0; i < Lotto.LIMIT; i++) {
            winningNumbers[i] = new LottoNumber(i + 1);
        }
        LottoTicket ticketWithNumbers = new LottoTicket(IntegerUtils.splitAndParseLottoNumber(myNumbers));
        LottoNumbers winningLotto = new LottoNumbers(winningNumbers);

        assertThat(ticketWithNumbers.announceRank(winningLotto, new LottoNumber(bonus)).getRank()).isEqualTo(expected);
    }

}
