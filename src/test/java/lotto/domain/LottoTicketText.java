package lotto.domain;

import lotto.util.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketText {

    @Test
    void 로또티켓_클래스생성_수동숫자(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        assertThat(lottoTicket.toString()).isEqualTo(numbers.toString());
    }

    @Test
    void 로또티켓_클래스생성_자동숫자(){
        LottoTicket lottoTicket = new LottoTicket(
                new NumberGenerator(){
                    @Override
                    public List<Integer> generateSixNumbers(){
                        return Arrays.asList(1,2,3,4,5,6);
                    }
                }.generateSixNumbers()
        );
        assertThat(lottoTicket.toString()).isEqualTo(Arrays.asList(1,2,3,4,5,6).toString());
    }

}
