package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @DisplayName("티켓 객체시 로또 번호 생성되는지 테스트")
    @Test
    void generateNumbersTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        LottoTicket ticket = new LottoTicket(numbers);

        assertThat(ticket.getNumbers().size()).isEqualTo(2);

    }

    @DisplayName("당첨 티켓 판별 및 상금 세팅 테스트")
    @Test
    void checkWinningTicketTest(){
        List<Integer> officialWinningNumbers = new ArrayList<>();
        officialWinningNumbers.add(1);
        officialWinningNumbers.add(2);
        officialWinningNumbers.add(3);
        officialWinningNumbers.add(4);
        officialWinningNumbers.add(5);
        officialWinningNumbers.add(6);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        LottoTicket ticket = new LottoTicket(numbers);
        ticket.checkWinningTicket(officialWinningNumbers);

        assertThat(ticket.getPrizeResult()).isEqualTo(Constant.LOTTO_PRIZE_FOURTH);

    }

}
