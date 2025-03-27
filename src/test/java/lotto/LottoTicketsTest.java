package lotto;

import lotto.domain.LottoTickets;
import lotto.strategy.AutoLottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketsTest {

    public static final int COUNT = 14;
    LottoTickets lottoTickets;

    @BeforeEach
    public void setUpLottoTickets() {
        lottoTickets = LottoTickets.fromNumbers(COUNT);
    }

    @Test
    @DisplayName("입력한 count에 맞는 lottoTickets list를 반환한다.")
    void fromNumbers(){
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(COUNT);
    }

    @Test
    @DisplayName("6개의 로토 번호를 만든다.")
    void generateAllLottoNumbers(){
        lottoTickets.generateAllLottoNumbers(new AutoLottoStrategy());
        assertThat(lottoTickets.getLottoTickets())
                .allSatisfy(ticket -> assertThat(ticket.getLottoNumbers()).hasSize(6));

    }
}
