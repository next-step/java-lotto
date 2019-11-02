package lotto.domain;

import lotto.util.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketText {

    @Test
    void 로또티켓_클래스생성_수동숫자(){
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoTicket1.toString()).isEqualTo(Arrays.asList(1,2,3,4,5,6).toString());

        LottoTicket lottoTicket2 = new LottoTicket("1,2,3,4,5,6");
        assertThat(lottoTicket2.toString()).isEqualTo(Arrays.asList(1,2,3,4,5,6).toString());
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
