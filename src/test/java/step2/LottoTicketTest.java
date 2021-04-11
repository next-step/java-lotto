package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.AutoNumberGenerator;
import step2.domain.LottoTicket;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    @DisplayName("로또 번호 6개 가져오는 테스트")
    void getLotto() {
        int expected = 6;

        LottoTicket lotto = new LottoTicket(new AutoNumberGenerator());
        List<Integer> numbers = lotto.getNumbers();
        int actual = numbers.size();

        assertEquals(expected, actual);
    }
}
