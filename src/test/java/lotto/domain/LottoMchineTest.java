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
    public void 티켓_생산_확인() {
        LottoTicket ticket = lottoMchine.createTicket();
        
        assertNumberOfRange(ticket.getNumbers());
        assertUniqueNumber(ticket.getNumbers());
    }

    private void assertUniqueNumber(List<Integer> numbers) {
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    private void assertNumberOfRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }
    
    @Test
    public void 당첨_3등_확인() {
        LottoTicket t1 = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8));
        LottoResult result = lottoMchine.check("1,2,3,4,5,6", Arrays.asList(t1));
        assertThat(result.getCountByMatchCount(3)).isEqualTo(1);
        assertThat(result.getRatePercent()).isEqualTo(5);
    }
    
    @Test
    public void 당첨_1등_확인() {
        LottoTicket t1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5,6));
        LottoResult result = lottoMchine.check("1,2,3,4,5,6", Arrays.asList(t1));
        assertThat(result.getCountByMatchCount(6)).isEqualTo(1);
    }
}
