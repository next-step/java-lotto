package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LottoMchineTest {

    private LottoMchine lottoMchine = null;
    
    @Before
    public void setup() {
        lottoMchine = new LottoMchine();
    }
    
    @Test
    public void 티켓_자동발급_검증() {
        LottoTicket ticket = lottoMchine.createTicket();
        
//        assertNumberOfRange(ticket.getNumbers());
//        assertUniqueNumber(ticket.getNumbers());
    }

//    @Test
//    public void 티켓_수동발급_검증() {
//        LottoTicket ticket = lottoMchine.createTicket(Arrays.asList(1,2,3,4,5,6));
//
//        assertNumberOfRange(ticket.getNumbers());
//        assertUniqueNumber(ticket.getNumbers());
//    }

    private void assertUniqueNumber(List<Integer> numbers) {
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    private void assertNumberOfRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }
}
