package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @DisplayName("6개의 숫자 외 다른 경우의 갯수로 생성될 경우 에러 발생하는지 테스트")
    @Test
    void constructLottoTicketTest(){
        List<Integer> normalLottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(normalLottoNumbers::add);
        LottoTicket normalLottoTicket = new LottoTicket(normalLottoNumbers);

        assertThatIllegalArgumentException().isThrownBy(()->{
            List<Integer> abnormalLottoNumbers = new ArrayList<>();
            IntStream.rangeClosed(1, 7).forEach(abnormalLottoNumbers::add);
            LottoTicket abnormalLottoTicket = new LottoTicket(abnormalLottoNumbers);
        });

    }
}
