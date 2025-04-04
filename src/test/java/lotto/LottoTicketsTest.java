package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.strategy.AutoLottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketsTest {

    public static final int COUNT = 14;
    LottoTickets lottoTickets;

    @BeforeEach
    public void setUpLottoTickets() {
        lottoTickets = LottoTickets.fromNumbers(COUNT,new AutoLottoStrategy());
    }

    @Test
    @DisplayName("입력한 count에 맞는 lottoTickets list를 반환한다.")
    void fromNumbers(){
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(COUNT);
    }

    @Test
    @DisplayName("두 LottoTickets 객체를 병합하면 모든 티켓이 포함된 새 객체를 반환한다")
    void merge() {
        LottoTicket manualTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTicket autoTicket = new LottoTicket("7,8,9,10,11,12");
        LottoTickets manual = new LottoTickets(List.of(manualTicket));
        LottoTickets auto = new LottoTickets(List.of(autoTicket));

        LottoTickets merged = LottoTickets.merge(manual, auto);

        assertThat(merged.getLottoTickets())
                .hasSize(2)
                .containsExactly(manualTicket, autoTicket);
    }

}
