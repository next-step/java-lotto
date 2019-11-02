package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketText {

    @Test
    void 로또티켓_클래스생성_수동숫자(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        assertThat(lottoTicket.toString()).isEqualTo(numbers.toString());
    }

}
