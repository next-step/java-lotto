package lotto;

import lotto.model.LottoTicket;
import lotto.model.ManualLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketTest {
    private static final int GAME_COUNT = 10;
    private static final int AUTO_GAME_COUNT = 7;

    LottoTicket lottoTicket;
    ManualLottoNumbers manualLottoNumbers;
    @BeforeEach
    void setting() {
        manualLottoNumbers = new ManualLottoNumbers();
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("1,2,3,4,5,6");
        manualLottoNumbers.setManualLottoNumbers(manualNumbers);
        lottoTicket = new LottoTicket(manualLottoNumbers, AUTO_GAME_COUNT);

    }

    @Test
    void 자동게임수_만큼_로또번호_자동생성() {
       assertThat(lottoTicket.getLottoTicketInfo().size()).isEqualTo(GAME_COUNT);
    }

}
