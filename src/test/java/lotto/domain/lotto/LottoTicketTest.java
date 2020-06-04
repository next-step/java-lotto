package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void init() {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lottoNumbers.add(LottoNumber.create(i));
        }
    }
    @Test
    void LottoTicket_생성() {
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        int lottoNumberSize = 6;
        assertThat(lottoTicket.size()).isEqualTo(lottoNumberSize);
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test
    void LottoTicket_1등_티켓_생성() {
        String winNumbers = "1, 2, 3, 4, 5, 6";
        int lottoNumberSize = 6;
        int matchWinLottoTicketCount = 6;

        LottoTicket winLottoTicket = new LottoTicket(winNumbers);
        LottoTicket newLottoTicket = new LottoTicket(winNumbers);

        assertThat(newLottoTicket.size()).isEqualTo(lottoNumberSize);
        assertThat(winLottoTicket.matchLottoTicketCount(newLottoTicket)).isEqualTo(matchWinLottoTicketCount);
    }

    @Test
    void hasBonusNumberTest_보너스넘버_있음() {
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        Boolean aBoolean = lottoTicket.hasBonusNumber(LottoNumber.create(4));
        assertThat(aBoolean).isTrue();
    }

    @Test
    void hasBonusNumberTest_보너스넘버_없음() {
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        Boolean aBoolean = lottoTicket.hasBonusNumber(LottoNumber.create(11));
        assertThat(aBoolean).isFalse();
    }

    @Test
    void matchLottoTicketCountTest() {
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoTicket randomLottoTicket = new LottoTicket();
        int matchLottoTicketCount = lottoTicket.matchLottoTicketCount(randomLottoTicket);
        assertThat(matchLottoTicketCount).isBetween(0, 6);
    }
}
